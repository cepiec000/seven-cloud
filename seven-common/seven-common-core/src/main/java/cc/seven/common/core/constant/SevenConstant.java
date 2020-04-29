package cc.seven.common.core.constant;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/24 17:51
 * @Version V1.0
 **/
public class SevenConstant {
    /**
     * 排序规则：降序
     */
    public static final String ORDER_DESC = "descending";
    /**
     * 排序规则：升序
     */
    public static final String ORDER_ASC = "ascending";

    /**
     * Gateway请求头TOKEN名称（不要有空格）
     */
    public static final String GATEWAY_TOKEN_HEADER = "GatewayToken";

    /**
     * Gateway请求头TOKEN值
     */
    public static final String GATEWAY_TOKEN_VALUE = "seven:gateway:123456";

    /**
     * OAUTH2 令牌类型 https://oauth.net/2/bearer-tokens/
     */
    public static final String OAUTH2_TOKEN_TYPE = "bearer";

    /**
     * 异步线程池名称
     */
    public static final String ASYNC_POOL="sevenAsyncThreadPool";

    /**
     * JAVA 默认临时目录
     */
    public static final String JAVA_TEMP_DIR="java.io.tmpdir";
    /**
     * 注册用户角色ID
     */
    public static Long REGISTER_ROLE_ID=2L;
    /**
     * 验证码 key前缀
     */
    public static final String CODE_PREFIX = "seven.captcha.";
    public static final String LOCALHOST = "localhost";
    public static final String LOCALHOST_IP = "127.0.0.1";
}
