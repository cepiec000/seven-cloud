package cc.seven.gateway.common.controller;

import cc.seven.common.core.entity.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Description: 流式异步返回 flux Mono对象
 * @Author chendongdong
 * @Date 2020/4/24 17:18
 * @Version V1.0
 **/
@Slf4j
@RestController
public class FallbackController {
    private Logger logger=LoggerFactory.getLogger(FallbackController.class);
    @RequestMapping("fallback/{name}")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ApiResult> systemFallback(@PathVariable String name) {
        String response = "服务访问超时，请稍后再试";
        logger.error("{}，目标微服务：{}", response, name);
        return Mono.just(ApiResult.fail(response));
    }

}
