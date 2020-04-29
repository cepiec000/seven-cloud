package com.seven.common.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/26 17:19
 * @Version V1.0
 **/
@ConfigurationProperties(prefix = "seven.lettuce.redis")
public class SevenLettuceRedisProperties {
    /**
     * 是否开启Lettuce Redis
     */
    private Boolean enable = true;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "FebsLettuceRedisProperties{" +
                "enable=" + enable +
                '}';
    }
}
