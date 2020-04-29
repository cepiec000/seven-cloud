package cc.seven.common.security.configure;

import cc.seven.common.security.handler.SevenAccessDeniedHandler;
import cc.seven.common.security.handler.SevenAuthExceptionEntryPoint;
import cc.seven.common.security.properties.SevenCloudSecurityProperties;
import cc.seven.common.core.constant.SevenConstant;
import cc.seven.common.core.utils.SevenUtil;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Base64Utils;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/26 14:08
 * @Version V1.0
 **/
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(SevenCloudSecurityProperties.class)
@ConditionalOnProperty(value = "seven.cloud.security.enable", havingValue = "true", matchIfMissing = true)
public class SevenCloudAuthAutoconfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public SevenAccessDeniedHandler accessDeniedHandler() {
        return new SevenAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public SevenAuthExceptionEntryPoint authenticationEntryPoint() {
        return new SevenAuthExceptionEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SevenCloudSecurityInteceptorConfigure febsCloudSecurityInteceptorConfigure() {
        return new SevenCloudSecurityInteceptorConfigure();
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            String gatewayToken = new String(Base64Utils.encode(SevenConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(SevenConstant.GATEWAY_TOKEN_HEADER, gatewayToken);
            String authorizationToken = SevenUtil.getCurrentTokenValue();
            requestTemplate.header(HttpHeaders.AUTHORIZATION, SevenConstant.OAUTH2_TOKEN_TYPE + authorizationToken);
        };
    }

}
