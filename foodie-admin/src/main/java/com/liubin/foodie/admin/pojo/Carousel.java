package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 轮播图
 *
 * @author liubin
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("carousel")
public class Carousel extends BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片 图片地址
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 背景色
     */
    @TableField(value = "bg_color")
    private String backgroundColor;

    /**
     * 商品id 商品id
     */
    @TableField(value = "item_id")
    private String itemId;

    /**
     * 商品分类id 商品分类id
     */
    @TableField(value = "cat_id")
    private String catId;

    /**
     * 轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类
     */
    private Integer type;

    /**
     * 轮播图展示顺序
     */
    private Integer sort;

    /**
     * 是否展示
     */
    @TableField(value = "is_show")
    private Integer isShow;

}