package com.liubin.foodie.controller;

import com.liubin.common.api.CommonResult;
import com.liubin.common.utils.CookieUtils;
import com.liubin.common.utils.JSONResult;
import com.liubin.common.utils.JsonUtils;
import com.liubin.foodie.pojo.Users;
import com.liubin.foodie.pojo.bo.UserBO;
import com.liubin.foodie.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liubin
 */
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public CommonResult register(@RequestBody UserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();
        // 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return CommonResult.failed("用户名或密码不能为空");
        }
        // 查询用户是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return CommonResult.failed("用户名已经存在");
        }
        Users userResult = userService.createUser(userBO);

        return CommonResult.success(userResult);
    }


    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public CommonResult login(@RequestBody UserBO userBO,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return CommonResult.failed("用户名或密码不能为空");
        }

        // 实现登录
        Users userResult = userService.queryUserForLogin(username,
                DigestUtils.md5DigestAsHex(password.getBytes()));

        if (userResult == null) {
            return CommonResult.failed("用户名或密码不正确");
        }

        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        return CommonResult.success(userResult);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestParam String userId,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");
        return JSONResult.ok();
    }


    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

}