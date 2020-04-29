package cc.seven.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/27 11:22
 * @Version V1.0
 **/
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:seven-auth.properties"})
@ConfigurationProperties(prefix = "seven.auth")
public class SevenAuthProperties {
    /**
     * 验证码配置
     */
    private SevenValidateCodeProperties code = new SevenValidateCodeProperties();
    /**
     * JWT加签密钥
     */
    private String jwtAccessKey;
    /**
     * 是否使用 JWT令牌
     */
    private Boolean enableJwt;

    /**
     * 社交登录所使用的 Client
     */
    private String socialLoginClientId;
}
