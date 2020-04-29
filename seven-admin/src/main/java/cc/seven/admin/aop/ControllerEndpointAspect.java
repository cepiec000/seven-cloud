package cc.seven.admin.aop;

import cc.seven.admin.annotation.ControllerEndpoint;
import cc.seven.admin.service.ILogService;
import cc.seven.common.core.exception.SevenException;
import cc.seven.common.core.utils.SevenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: 请求日志 写入
 * @Author chendongdong
 * @Date 2020/4/26 14:46
 * @Version V1.0
 **/
@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class ControllerEndpointAspect extends BaseAspectSupport {
    private final ILogService logService;

    @Pointcut("@annotation(cc.seven.admin.annotation.ControllerEndpoint)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws SevenException {
        Object result;
        Method targetMethod = resolveMethod(point);
        ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
        String operation = annotation.operation();
        long start = System.currentTimeMillis();
        try {
            result = point.proceed();
            if (StringUtils.isNotBlank(operation)) {
                String username = SevenUtil.getCurrentUsername();
                String ip = SevenUtil.getHttpServletRequestIpAddress();
                logService.saveLog(point, targetMethod, ip, operation, username, start);
            }
            return result;
        } catch (Throwable throwable) {
            log.error(throwable.getMessage(), throwable);
            String exceptionMessage = annotation.exceptionMessage();
            String message = throwable.getMessage();
            String error = SevenUtil.containChinese(message) ? exceptionMessage + "，" + message : exceptionMessage;
            throw new SevenException(error);
        }
    }
}
