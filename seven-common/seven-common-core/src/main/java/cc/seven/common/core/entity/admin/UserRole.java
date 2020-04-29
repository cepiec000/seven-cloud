package cc.seven.common.core.entity.admin;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author seven
 */
@Data
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = -3166012934498268403L;

    @TableId(value = "USER_ID")
    private Long userId;

    @TableId(value = "ROLE_ID")
    private Long roleId;

}