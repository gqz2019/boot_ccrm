package com.gqz.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gqz20
 * @TableName customer
 */
@TableName(value = "customer")
@Data
@Accessors(chain = true)
public class Customer implements Serializable {
    /**
     * 客户编号(主键)
     */
    @TableId(value = "cust_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户名称
     */
    @TableField(value = "cust_name")
    private String name;

    /**
     * 负责人id
     */
    @TableField(value = "cust_user_id")
    private Integer userId;

    /**
     * 创建人id
     */
    @TableField(value = "cust_create_id")
    private Integer createId;

    /**
     * 客户信息来源
     */
    @TableField(value = "cust_source")
    private String source;

    /**
     * 客户所属行业
     */
    @TableField(value = "cust_industry")
    private String industry;

    /**
     * 客户级别
     */
    @TableField(value = "cust_level")
    private String level;

    /**
     * 联系人
     */
    @TableField(value = "cust_linkman")
    private String linkman;

    /**
     * 固定电话
     */
    @TableField(value = "cust_phone")
    private String phone;

    /**
     * 移动电话
     */
    @TableField(value = "cust_mobile")
    private String mobile;

    /**
     * 邮政编码
     */
    @TableField(value = "cust_zipcode")
    private String zipcode;

    /**
     * 联系地址
     */
    @TableField(value = "cust_address")
    private String address;

    /**
     * 创建时间
     */
    @TableField(value = "cust_createtime")
    private LocalDateTime creationTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private Integer start;
    @TableField(exist = false)
    private Integer rows;
}