package cc.seven.admin.service.impl;

import cc.seven.admin.entity.TradeLog;
import cc.seven.admin.mapper.TradeLogMapper;
import cc.seven.admin.service.ITradeLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Seven
 */
@Slf4j
@Service("tradeLogService")
public class TradeLogServiceImpl extends ServiceImpl<TradeLogMapper, TradeLog> implements ITradeLogService {

    ConcurrentHashMap<String, Long> hashMap = new ConcurrentHashMap<>();

    @Override
    @LcnTransaction
    public void packageAndSend(TradeLog tradeLog) {
        TradeLog tl = new TradeLog();
        tl.setGoodsId(tradeLog.getGoodsId());
        tl.setGoodsName(tradeLog.getGoodsName());
        tl.setStatus("打包完毕，开始物流配送！");
        tl.setCreateTime(new Date());

        this.save(tl);
        log.info("商品ID为{}，名称为{}的商品打包完毕，开始物流配送", tradeLog.getGoodsId(), tradeLog.getGoodsName());

//        String groupId= TracingContext.tracing().groupId();
//        hashMap.put(groupId, tradeLog.getId());
//        throw new RuntimeException("遠程接口失敗");
    }

}
