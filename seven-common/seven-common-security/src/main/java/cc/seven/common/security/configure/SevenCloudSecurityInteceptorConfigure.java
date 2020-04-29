package cc.seven.common.security.configure;

import cc.seven.common.security.interceptor.SevenServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author seven
 */
public class SevenCloudSecurityInteceptorConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor sevenServerProtectInterceptor() {
        return new SevenServerProtectInterceptor();
    }

    @Override
    @SuppressWarnings("all")
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sevenServerProtectInterceptor());
    }
}
