package cc.seven.common.security.annotation;

import cc.seven.common.security.configure.SevenCloudResourceConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/26 13:58
 * @Version V1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SevenCloudResourceConfigure.class)
public @interface EnableSevenCloudResource {
}
