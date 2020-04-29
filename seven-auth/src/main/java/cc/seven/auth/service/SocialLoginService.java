package cc.seven.auth.service;

import cc.seven.auth.entity.BindUser;
import cc.seven.auth.entity.UserConnection;
import cc.seven.common.core.entity.ApiResult;
import cc.seven.common.core.exception.SevenException;

import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.List;

/**
 * @author MrBird
 */
public interface SocialLoginService {

    /**
     * 解析第三方登录请求
     *
     * @param oauthType 第三方平台类型
     * @return AuthRequest
     * @throws SevenException 异常
     */
    AuthRequest renderAuth(String oauthType) throws SevenException;

    /**
     * 处理第三方登录（绑定页面）
     *
     * @param oauthType 第三方平台类型
     * @param callback  回调
     * @return FebsResponse
     * @throws SevenException 异常
     */
    ApiResult resolveBind(String oauthType, AuthCallback callback) throws SevenException;

    /**
     * 处理第三方登录（登录页面）
     *
     * @param oauthType 第三方平台类型
     * @param callback  回调
     * @return FebsResponse
     * @throws SevenException 异常
     */
    ApiResult resolveLogin(String oauthType, AuthCallback callback) throws SevenException;

    /**
     * 绑定并登录
     *
     * @param bindUser 绑定用户
     * @param authUser 第三方平台对象
     * @return OAuth2AccessToken 令牌对象
     * @throws SevenException 异常
     */
    OAuth2AccessToken bindLogin(BindUser bindUser, AuthUser authUser) throws SevenException;

    /**
     * 注册并登录
     *
     * @param registUser 注册用户
     * @param authUser   第三方平台对象
     * @return OAuth2AccessToken 令牌对象
     * @throws SevenException 异常
     */
    OAuth2AccessToken signLogin(BindUser registUser, AuthUser authUser) throws SevenException;

    /**
     * 绑定
     *
     * @param bindUser 绑定对象
     * @param authUser 第三方平台对象
     * @throws SevenException 异常
     */
    void bind(BindUser bindUser, AuthUser authUser) throws SevenException;

    /**
     * 解绑
     *
     * @param bindUser  绑定对象
     * @param oauthType 第三方平台对象
     * @throws SevenException 异常
     */
    void unbind(BindUser bindUser, String oauthType) throws SevenException;

    /**
     * 根据用户名获取绑定关系
     *
     * @param username 用户名
     * @return 绑定关系集合
     */
    List<UserConnection> findUserConnections(String username);
}
