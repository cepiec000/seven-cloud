package cc.seven.cloud.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/28 10:43
 * @Version V1.0
 **/
@EnableAdminServer
@SpringBootApplication
public class SevenCloudAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SevenCloudAdminApplication.class, args);
    }
}
