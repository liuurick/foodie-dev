package com.liubin.foodie.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.liubin.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginLog extends BaseEntity {

    /**
     * 登录主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String loginId;

    @TableField(value = "login_name")
    private String loginName;

    /**
     * 登录途径
     */
    @TableField(value = "login_way")
    private Integer loginWay;

    /**
     * 登录平台
     */
    @TableField(value = "login_platform")
    private String loginPlatform;

    @TableField(value = "login_ip")
    private String loginIp;

    @TableField(value = "login_time")
    private DateTime loginTime;

    /**
     * 1-成功 2-用户错误 3-密码错误 4-账号锁定
     */
    @TableField(value = "login_status")
    private Integer loginStatus;
}
