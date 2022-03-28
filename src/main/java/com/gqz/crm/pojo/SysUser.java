package com.gqz.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 
 * @author gqz20
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
@Accessors(chain = true)
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户账号
     */
    @TableField(value = "user_code")
    private String userCode;

    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField(value = "user_password")
    private String userPassword;

    /**
     * 1:正常,0:暂停
     */
    @TableField(value = "user_state")
    private Integer usersState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}