package cc.seven.server.test.feign;

import cc.seven.common.core.constant.SevenServerConstant;
import cc.seven.common.core.entity.ApiResult;
import cc.seven.common.core.entity.admin.QueryRequest;
import cc.seven.common.core.entity.admin.SystemUser;
import cc.seven.server.test.entity.TradeLog;
import cc.seven.server.test.feign.fallback.RemoteServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/28 14:15
 * @Version V1.0
 **/
@FeignClient("seven-admin-server")
public interface IRemoteService {
    /**
     * 打包派送
     *
     * @param tradeLog 交易日志
     */
    @PostMapping("/package/send")
    void packageAndSend(@RequestBody TradeLog tradeLog);
    /**
     * remote /user endpoint
     *
     * @param queryRequest queryRequest
     * @param user         user
     * @return FebsResponse
     */
    @GetMapping("/user")
    ApiResult userList(@RequestParam("queryRequest") QueryRequest queryRequest, @RequestParam("user") SystemUser user);
}
