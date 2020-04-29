package cc.seven.server.test.controller;

import cc.seven.common.core.entity.ApiResult;
import cc.seven.common.core.entity.admin.QueryRequest;
import cc.seven.common.core.entity.admin.SystemUser;
import cc.seven.common.core.utils.SevenUtil;
import cc.seven.server.test.entity.TradeLog;
import cc.seven.server.test.feign.IRemoteService;
import cc.seven.server.test.service.ITradeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author seven
 * @NoArgsConstructor ： 生成一个无参数的构造方法
 * @AllArgsContructor：  会生成一个包含所有变量
 * @RequiredArgsConstructor： 会生成一个包含常量，和标识了NotNull的变量的构造方法。生成的构造方法是私有的private。
 */

/***
 * 分布式事务 测试结果
 * 系统A  系统B
 * A--->B ,B出错，A未出错，B没有捕获异常  ，B事务回滚，A事务回滚
 * A--->B ,B出错，A未出错，B捕获异常  ，B事务回滚，A事务不回滚
 * A--->B ,A出错，B未出错  ，AB事务都会回滚
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {

    private final IRemoteService remoteUserService;
    private final ITradeLogService tradeLogService;

    @GetMapping("testJob")
    public ApiResult testJob(){
        return ApiResult.success("成功");
    }
    /**
     * 用于演示 Feign调用受保护的远程方法
     */
    @GetMapping("user/list")
    public ApiResult getRemoteUserList(QueryRequest request, SystemUser user) {
        ApiResult result= remoteUserService.userList(request, user);
        return result;
    }

    /**
     * 测试分布式事务
     */
    @GetMapping("pay")
    public void orderAndPay(TradeLog tradeLog) {
        this.tradeLogService.orderAndPay(tradeLog);
    }

    /**
     * 获取当前用户信息
     */
    @GetMapping("user")
    public Map<String, Object> currentUser() {
        Map<String, Object> map = new HashMap<>(5);
        map.put("currentUser", SevenUtil.getCurrentUser());
        map.put("currentUsername", SevenUtil.getCurrentUsername());
        map.put("currentUserAuthority", SevenUtil.getCurrentUserAuthority());
        map.put("currentTokenValue", SevenUtil.getCurrentTokenValue());
        map.put("currentRequestIpAddress", SevenUtil.getHttpServletRequestIpAddress());
        return map;
    }
}

