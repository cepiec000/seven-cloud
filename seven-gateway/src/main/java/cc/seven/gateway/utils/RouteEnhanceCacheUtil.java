package cc.seven.gateway.utils;


import cc.seven.common.core.constant.SevenConstant;

/**
 * @author MrBird
 */
public class RouteEnhanceCacheUtil {

    private static final String BLACKLIST_CHACHE_KEY_PREFIX = "seven:route:blacklist:";
    private static final String RATELIMIT_CACHE_KEY_PREFIX = "seven:route:ratelimit:";
    private static final String RATELIMIT_COUNT_KEY_PREFIX = "seven:route:ratelimit:cout:";

    public static String getBlackListCacheKey(String ip) {
        if (SevenConstant.LOCALHOST.equalsIgnoreCase(ip)) {
            ip = SevenConstant.LOCALHOST_IP;
        }
        return String.format("%s%s", BLACKLIST_CHACHE_KEY_PREFIX, ip);
    }

    public static String getBlackListCacheKey() {
        return String.format("%sall", BLACKLIST_CHACHE_KEY_PREFIX);
    }

    public static String getRateLimitCacheKey(String uri, String method) {
        return String.format("%s%s:%s", RATELIMIT_CACHE_KEY_PREFIX, uri, method);
    }

    public static String getRateLimitCountKey(String uri, String ip) {
        return String.format("%s%s:%s", RATELIMIT_COUNT_KEY_PREFIX, uri, ip);
    }
}
