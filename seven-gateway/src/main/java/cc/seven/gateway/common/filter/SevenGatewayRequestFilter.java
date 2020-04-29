package cc.seven.gateway.common.filter;

import cc.seven.common.core.constant.SevenConstant;
import cc.seven.gateway.enable.service.RouteEnhanceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Base64Utils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/24 17:46
 * @Version V1.0
 **/
@Component
@Order(0)
@RequiredArgsConstructor
public class SevenGatewayRequestFilter implements GlobalFilter {
    private static Logger logger=LoggerFactory.getLogger(SevenGatewayRequestFilter.class);

    private final RouteEnhanceService routeEnhanceService;
    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    //是否开启网关 校验
    @Value("${seven.gateway.enhance:false}")
    private Boolean routeEhance;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (routeEhance) {
            //判断是否在黑名单
            Mono<Void> balckListResult = routeEnhanceService.filterBalckList(exchange);
            if (balckListResult != null) {
                routeEnhanceService.saveBlockLogs(exchange);
                return balckListResult;
            }
//            限流操作
            Mono<Void> rateLimitResult = routeEnhanceService.filterRateLimit(exchange);
            if (rateLimitResult != null) {
                routeEnhanceService.saveRateLimitLogs(exchange);
                return rateLimitResult;
            }
//            记录日志
            routeEnhanceService.saveRequestLogs(exchange);
        }

        byte[] token = Base64Utils.encode((SevenConstant.GATEWAY_TOKEN_VALUE).getBytes());
        String[] headerValues = {new String(token)};
        ServerHttpRequest build = exchange.getRequest().mutate().header(SevenConstant.GATEWAY_TOKEN_HEADER, headerValues).build();
        ServerWebExchange newExchange = exchange.mutate().request(build).build();
        return chain.filter(newExchange);
    }
}
