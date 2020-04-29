package cc.seven.admin.exception;

import cc.seven.common.core.handler.BaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/26 14:58
 * @Version V1.0
 **/
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends BaseExceptionHandler {
}
