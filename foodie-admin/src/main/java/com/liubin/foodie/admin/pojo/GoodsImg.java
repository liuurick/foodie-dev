package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("goods_img")
public class GoodsImg extends BaseEntity{
    /**
     * 图片主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品外键id 商品外键id
     */
    @TableField("goods_id")
    private String goodsId;

    /**
     * 图片地址 图片地址
     */
    @TableField("url")
    private String url;

    /**
     * 顺序 图片顺序，从小到大
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 是否主图 是否主图，1：是，0：否
     */
    @TableField("is_main")
    private Integer isMain;
}