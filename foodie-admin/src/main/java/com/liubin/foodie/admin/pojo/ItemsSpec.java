package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("items_spec")
public class ItemsSpec extends BaseEntity{
    
    /**
     * 商品规格id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品外键id
     */
    @TableField("item_id")
    private String itemId;

    /**
     * 规格名称
     */
    @TableField("name")
    private String name;

    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 折扣力度
     */
    @TableField("discounts")
    private BigDecimal discounts;

    /**
     * 优惠价
     */
    @TableField("price_discount")
    private Integer priceDiscount;

    /**
     * 原价
     */
    @TableField("price_normal")
    private Integer priceNormal;

}