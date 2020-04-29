package cc.seven.gateway.enable.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author seven
 */
@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitRule {

    public static final String CLOSE = "0";
    public static final String OPEN = "1";

    public static final String METHOD_ALL = "all";

    @Id
    private String id;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 请求方法，如果为ALL则表示对所有方法生效
     */
    private String requestMethod;
    /**
     * 限制时间起
     */
    private String limitFrom;
    /**
     * 限制时间止
     */
    private String limitTo;
    /**
     * 次数
     */
    private String count;
    /**
     * 时间周期，单位秒
     */
    private String intervalSec;
    /**
     * 状态，0关闭，1开启
     */
    private String status;
    /**
     * 规则创建时间
     */
    private String createTime;

    @Transient
    private String createTimeFrom;
    @Transient
    private String createTimeTo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getLimitFrom() {
        return limitFrom;
    }

    public void setLimitFrom(String limitFrom) {
        this.limitFrom = limitFrom;
    }

    public String getLimitTo() {
        return limitTo;
    }

    public void setLimitTo(String limitTo) {
        this.limitTo = limitTo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getIntervalSec() {
        return intervalSec;
    }

    public void setIntervalSec(String intervalSec) {
        this.intervalSec = intervalSec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(String createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public String getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(String createTimeTo) {
        this.createTimeTo = createTimeTo;
    }
}
