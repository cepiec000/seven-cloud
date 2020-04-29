package cc.seven.admin.service;

import cc.seven.admin.entity.TradeLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author seven
 */
public interface ITradeLogService extends IService<TradeLog> {

    /**
     * 打包并派送
     *
     * @param tradeLog 交易日志
     */
    void packageAndSend(TradeLog tradeLog);
}
