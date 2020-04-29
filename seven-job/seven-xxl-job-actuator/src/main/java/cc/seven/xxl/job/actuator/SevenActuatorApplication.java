package cc.seven.xxl.job.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/28 18:46
 * @Version V1.0
 **/
@SpringBootApplication(scanBasePackages = "cc.seven.xxl.job.actuator")
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
@EnableFeignClients
public class SevenActuatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SevenActuatorApplication.class,args);
    }
}
