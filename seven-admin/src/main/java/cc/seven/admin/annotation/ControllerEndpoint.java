package cc.seven.admin.annotation;

public @interface ControllerEndpoint {
    String operation() default "";

    String exceptionMessage() default "FEBS系统内部异常";
}
