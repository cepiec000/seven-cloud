package cc.seven.server.test.service;

import cc.seven.server.test.entity.TradeLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author seven
 */
public interface ITradeLogService extends IService<TradeLog> {

    /**
     * 下单并支付
     *
     * @param tradeLog 交易日志
     */
    void orderAndPay(TradeLog tradeLog);
}