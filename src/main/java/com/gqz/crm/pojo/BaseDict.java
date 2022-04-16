package com.gqz.crm.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 
 * @author 20
 * @TableName base_dict
 */
@TableName(value ="base_dict")
@Data
@Accessors(chain = true)
public class BaseDict implements Serializable {
    /**
     * 数据字典id(主键)
     */
    @TableId(value = "dict_id")
    private String id;

    /**
     * 数据字典类别代码
     */
    @TableField(value = "dict_type_code")
    private String typeCode;

    /**
     * 数据字典类别名称
     */
    @TableField(value = "dict_type_name")
    private String typeName;

    /**
     * 数据字典项目名称
     */
    @TableField(value = "dict_item_name")
    private String itemName;

    /**
     * 数据字典项目代码(可为空)
     */
    @TableField(value = "dict_item_code")
    private String itemCode;

    /**
     * 排序字段
     */
    @TableField(value = "dict_sort")
    private Integer sort;

    /**
     * 1:使用 0:停用
     */
    @TableField(value = "dict_enable")
    private String enable;

    /**
     * 备注
     */
    @TableField(value = "dict_memo")
    private String memo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}