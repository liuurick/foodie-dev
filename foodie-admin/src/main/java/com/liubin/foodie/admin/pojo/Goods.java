package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("goods")
public class Goods extends BaseEntity{

    /**
     * 商品主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 分类外键id 分类id
     */
    @TableField("cat_id")
    private Integer catId;

    /**
     * 一级分类外键id
     */
    @TableField("root_cat_id")
    private Integer rootCatId;

    /**
     * 累计销售 累计销售
     */
    @TableField("sell_counts")
    private Integer sellCounts;

    /**
     * 上下架状态 上下架状态,1:上架 2:下架
     */
    @TableField("on_off_status")
    private Integer onOffStatus;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

    /**
     * 商品内容 商品内容
     */
    @TableField("content")
    private String content;
}