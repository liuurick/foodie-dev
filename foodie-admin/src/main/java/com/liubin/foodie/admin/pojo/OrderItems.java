package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@TableName("order_items")
@Data
public class OrderItems extends BaseEntity{
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 归属订单id
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 商品id
     */
    @TableField("item_id")
    private String itemId;

    /**
     * 商品图片
     */
    @TableField("item_img")
    private String itemImg;

    /**
     * 商品名称
     */
    @TableField("item_name")
    private String itemName;

    /**
     * 规格id
     */
    @TableField("item_spec_id")
    private String itemSpecId;

    /**
     * 规格名称
     */
    @TableField("item_spec_name")
    private String itemSpecName;

    /**
     * 成交价格
     */
    private Integer price;

    /**
     * 购买数量
     */
    @TableField("buy_counts")
    private Integer buyCounts;
}