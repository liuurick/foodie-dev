package com.liubin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

}