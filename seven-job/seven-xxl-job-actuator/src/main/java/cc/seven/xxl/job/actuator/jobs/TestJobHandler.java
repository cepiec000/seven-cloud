package cc.seven.xxl.job.actuator.jobs;

import cc.seven.common.core.entity.ApiResult;
import cc.seven.xxl.job.actuator.feign.TestServerFeign;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/29 10:54
 * @Version V1.0
 **/
@Component
public class TestJobHandler extends IJobHandler {
    @Autowired
    private TestServerFeign testServerFeign;

    @Override
    public ReturnT<String> execute(String params) throws Exception {
        XxlJobLogger.log("xxl-job test-server params:{}", params);
        try {
            ApiResult result = testServerFeign.testJob();
            XxlJobLogger.log("xxl-job test-server result:{}", result);
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job test-server error:{}", e.getMessage());
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }
}
