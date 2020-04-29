package cc.seven.common.core.entity.admin;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author seven
 */
@Data
@TableName("t_user_data_permission")
public class UserDataPermission {

    @TableId("USER_ID")
    private Long userId;
    @TableId("DEPT_ID")
    private Long deptId;

}