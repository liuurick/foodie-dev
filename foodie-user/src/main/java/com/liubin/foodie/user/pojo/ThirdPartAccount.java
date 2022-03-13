package com.liubin.foodie.user.pojo;

import com.dino.registermodule.base.BaseEntity;
import lombok.Data;

/**
 * 第三方登录实体类
 */
@Data
public class ThirdPartAccount extends BaseEntity {
    private String loginId;
    private String openId;
    private String thirdPartyAccountType;
}
