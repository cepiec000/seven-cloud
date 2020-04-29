package cc.seven.common.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/24 17:20
 * @Version V1.0
 **/
@Data
public class ApiResult<T> implements Serializable {
    public static final int FAIL = 1;
    public static final int SUCCESS = 1;
    public static final int UNKNOWN_ERROR = -1;
    /**
     * 处理结果code，0 表示成功，非零表示失败,正数表示已知错误，负数表示未知异常
     **/
    private int code;
    /**
     * 错误信息，一般只在处理失败时才有
     **/
    private String message;
    /**
     * 结果数据
     **/
    private T data;

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(SUCCESS, null, data);
    }

    public static <T> ApiResult<T> fail(String msg) {
        return new ApiResult<>(FAIL, msg);
    }

    public static <T> ApiResult<T> fail(int code, String msg) {
        return new ApiResult<>(code, msg);
    }

    public static <T> ApiResult<T> fail(int code, String msg, T obj) {
        return new ApiResult<>(code, msg, obj);
    }

    public static <T> ApiResult<T> unknownError(String msg) {
        return new ApiResult<>(UNKNOWN_ERROR, msg);
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult(T data) {
        this.data = data;
    }
}
