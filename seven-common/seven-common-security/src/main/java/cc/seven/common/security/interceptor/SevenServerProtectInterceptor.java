package cc.seven.common.security.interceptor;

import cc.seven.common.core.constant.SevenConstant;
import cc.seven.common.core.entity.ApiResult;
import cc.seven.common.core.utils.SevenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Seven
 */
public class SevenServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Gateway Token
        String token = request.getHeader(SevenConstant.GATEWAY_TOKEN_HEADER);
        String gatewayToken = new String(Base64Utils.encode(SevenConstant.GATEWAY_TOKEN_VALUE.getBytes()));
        // 校验 Gateway Token的正确性
        if (StringUtils.equals(gatewayToken, token)) {
            return true;
        } else {
            SevenUtil.makeResponse(response, MediaType.APPLICATION_JSON_VALUE,
                    HttpServletResponse.SC_FORBIDDEN, ApiResult.fail("请通过网关获取资源"));
            return false;
        }
    }

    public static void main(String[] args) {
        String gatewayToken = new String(Base64Utils.encode(SevenConstant.GATEWAY_TOKEN_VALUE.getBytes()));
        System.out.println(gatewayToken);
    }
}
