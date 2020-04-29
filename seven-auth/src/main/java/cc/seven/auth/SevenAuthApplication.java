package cc.seven.auth;

import cc.seven.common.security.annotation.EnableSevenCloudResource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/27 14:27
 * @Version V1.0
 **/
@SpringBootApplication
@EnableSevenCloudResource
@MapperScan("cc.seven.auth.mapper")
public class SevenAuthApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SevenAuthApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
