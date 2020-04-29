package cc.seven.admin.controller;

import cc.seven.admin.entity.TradeLog;
import cc.seven.admin.service.ITradeLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final ITradeLogService tradeLogService;

    @PostMapping("package/send")
    public void packageSend(@RequestBody TradeLog tradeLog) {
        try {
            this.tradeLogService.packageAndSend(tradeLog);
        }catch (Exception e){
            log.error("远程接口如果外层捕获了异常，会不会提交分布式事物呢，答案：不会影响调用方的事务。");
        }
    }
}
