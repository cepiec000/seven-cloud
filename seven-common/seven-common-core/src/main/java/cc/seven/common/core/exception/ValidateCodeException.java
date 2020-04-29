package cc.seven.common.core.exception;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/27 10:39
 * @Version V1.0
 **/
public class ValidateCodeException extends Exception {
    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message) {
        super(message);
    }
}
