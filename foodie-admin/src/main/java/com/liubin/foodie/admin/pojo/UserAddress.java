package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_address")
public class UserAddress extends BaseEntity{
    
    /**
     * 地址主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 收件人姓名
     */
    @TableField("receiver")
    private String receiver;

    /**
     * 收件人手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 省份
     */
    @TableField("province")
    private String province;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 区县
     */
    @TableField("district")
    private String district;

    /**
     * 详细地址
     */
    @TableField("detail")
    private String detail;

    /**
     * 扩展字段
     */
    @TableField("extand")
    private String extand;

    /**
     * 是否默认地址
     */
    @TableField("is_default")
    private Integer isDefault;
}