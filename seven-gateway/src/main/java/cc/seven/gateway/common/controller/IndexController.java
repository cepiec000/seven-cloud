package cc.seven.gateway.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/24 17:23
 * @Version V1.0
 **/
@RestController
public class IndexController {
    @RequestMapping("/")
    public Mono<String> index() {
        return Mono.just("欢迎访问，seven cloud gateway 网关");
    }
}
