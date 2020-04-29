package cc.seven.admin.entity;


import cc.seven.common.core.entity.admin.Tree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Seven
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends Tree<Menu> {

    private String path;
    private String component;
    private String perms;
    private String icon;
    private String type;
    private Integer orderNum;
}
