package com.liubin.foodie.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liubin
 */
@Data
@TableName("category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 分类类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 父id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 图标
     */
    @TableField("logo")
    private String logo;

    /**
     * 口号
     */
    @TableField("slogan")
    private String slogan;

    /**
     * 分类图
     */
    @TableField("cat_image")
    private String catImage;

    /**
     * 背景颜色
     */
    @TableField("bg_color")
    private String bgColor;

    /**
     * 是否删除:0:正常,1删除
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_update")
    private Date gmtUpdate;


    /**
     * 创建者id
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 更新者id
     */
    @TableField("update_by")
    private Long updateBy;

}