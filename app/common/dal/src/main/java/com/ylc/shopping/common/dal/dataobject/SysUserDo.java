package com.ylc.shopping.common.dal.dataobject;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto created
 * @since 2019-01-19
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserDo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    @TableField("sys_role_id")
    private String sysRoleId;

    @TableField("login_name")
    private String loginName;

    @TableField("login_password")
    private String loginPassword;

    @TableField("sys_permission_id")
    private String sysPermissionId;


}
