package cc.seven.xxl.job.actuator.feign;

import cc.seven.common.core.entity.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/29 10:15
 * @Version V1.0
 **/
@FeignClient("seven-server-test")
public interface TestServerFeign {
    @GetMapping("/testJob")
    ApiResult testJob();
}
