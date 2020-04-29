package cc.seven.admin.entity;

import cc.seven.common.core.entity.admin.Tree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author seven
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends Tree<Dept> {

    private Integer orderNum;
}
