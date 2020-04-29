package cc.seven.server.test;

import cc.seven.common.security.annotation.EnableSevenCloudResource;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: demo
 * @Author chendongdong
 * @Date 2020/4/28 11:32
 * @Version V1.0
 **/
/**开启feign**/
@EnableFeignClients
/**开启spring boot 服务**/
@SpringBootApplication(scanBasePackages = {"cc.seven.server.test"})
/**开启 资源 保护**/
@EnableSevenCloudResource
/**开启tx事物管理**/
@EnableTransactionManagement
/**开启tx 分布式事物**/
@EnableDistributedTransaction
@MapperScan("cc.seven.server.test.mapper")
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class
})
/**nacos 注册中心客户端开启**/
@EnableDiscoveryClient
public class TestServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TestServerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
