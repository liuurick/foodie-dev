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
@TableName("goods_comments")
public class GoodsComments extends BaseEntity{

    /**
     * id主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id 用户名须脱敏
     */
    @TableField("user_id")
    private String userId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private String goodsId;

    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 商品规格id 可为空
     */
    @TableField("goods_spec_id")
    private String goodsSpecId;

    /**
     * 规格名称 可为空
     */
    @TableField("sepc_name")
    private String sepcName;

    /**
     * 评价等级 1：好评 2：中评 3：差评
     */
    @TableField("comment_level")
    private Integer commentLevel;

    /**
     * 评价内容
     */
    private String content;

}