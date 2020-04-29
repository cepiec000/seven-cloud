package cc.seven.server.test.feign.fallback;

import cc.seven.common.core.entity.ApiResult;
import cc.seven.common.core.entity.admin.QueryRequest;
import cc.seven.common.core.entity.admin.SystemUser;
import cc.seven.server.test.entity.TradeLog;
import cc.seven.server.test.feign.IRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/28 14:16
 * @Version V1.0
 **/
@Slf4j
@Component
public class RemoteServiceFallback implements IRemoteService {
    @Override
    public void packageAndSend(TradeLog tradeLog) {
        log.error("调用失败 packageandsend ->{}");
    }

    @Override
    public ApiResult userList(QueryRequest queryRequest, SystemUser user) {
        return ApiResult.fail("查询用户失败");
    }
}
