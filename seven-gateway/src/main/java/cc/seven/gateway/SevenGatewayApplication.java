package cc.seven.gateway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/24 17:25
 * @Version V1.0
 **/
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class SevenGatewayApplication {
    public static void main(String[] args) {
        //传统启动方式 非flux web 流式
        //SpringApplication.run(SevenGatewayApplication.class, args);

        new SpringApplicationBuilder(SevenGatewayApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
