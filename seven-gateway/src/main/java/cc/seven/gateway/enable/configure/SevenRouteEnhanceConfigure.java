package cc.seven.gateway.enable.configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/27 17:29
 * @Version V1.0
 **/
@EnableAsync
@Configuration
@EnableReactiveMongoRepositories(basePackages = "cc.seven.gateway.enable.mapper")
@ConditionalOnProperty(name = "seven.gateway.enhance", havingValue = "true")
public class SevenRouteEnhanceConfigure {
}
