package cc.seven.admin;

import cc.seven.common.security.annotation.EnableSevenCloudResource;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/26 16:12
 * @Version V1.0
 **/
@EnableAsync
@SpringBootApplication
@EnableSevenCloudResource
@EnableTransactionManagement
@EnableDistributedTransaction
@MapperScan("cc.seven.admin.mapper")
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class
})
@EnableDiscoveryClient
public class SevenAdminApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SevenAdminApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
