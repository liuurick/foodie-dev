package com.liubin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liubin
 */
@Data
public class Users {
    /**
     * 主键id 用户id
     */
    @Id
    private String id;

    /**
     * 用户名 用户名
     */
    private String username;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 昵称 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 头像
     */
    private String face;

    /**
     * 手机号 手机号
     */
    private String mobile;

    /**
     * 邮箱地址 邮箱地址
     */
    private String email;

    /**
     * 性别 性别 1:男  0:女  2:保密
     */
    private Integer sex;

    /**
     * 生日 生日
     */
    private Date birthday;

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