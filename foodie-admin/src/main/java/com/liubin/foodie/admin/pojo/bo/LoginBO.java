package com.liubin.foodie.admin.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liubin
 */
@ApiModel(value = "登录对象BO", description = "从客户端，由用户传入的数据封装在此entity中")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBO {

    @ApiModelProperty(value = "用户名", name = "username", example = "liubin", required = true)
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;
}
