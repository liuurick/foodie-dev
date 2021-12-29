package com.liubin.foodie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liubin
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("users")
public class Users extends BaseEntity{
    /**
     * 主键id 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码 密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 真实姓名
     */
    @TableField("realname")
    private String realname;

    /**
     * 头像
     */
    @TableField("face")
    private String face;

    /**
     * 手机号 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 邮箱地址 邮箱地址
     */
    @TableField("email")
    private String email;

    /**
     * 性别 性别 1:男  0:女  2:保密
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 生日 生日
     */
    @TableField("birthday")
    private Date birthday;

}