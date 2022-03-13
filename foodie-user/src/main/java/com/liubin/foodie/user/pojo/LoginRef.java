package com.liubin.foodie.user.pojo;

import com.liubin.common.entity.BaseEntity;
import lombok.Data;

/**
 * 用户影射实体类
 */
@Data
public class LoginRef extends BaseEntity {
    private String loginId;
    private String userId;
}
