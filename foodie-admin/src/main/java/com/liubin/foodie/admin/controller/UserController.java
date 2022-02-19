package com.liubin.foodie.admin.controller;

import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.common.utils.CookieUtils;
import com.liubin.common.utils.JsonUtils;
import com.liubin.common.utils.MD5Utils;
import com.liubin.foodie.admin.pojo.Users;
import com.liubin.foodie.admin.pojo.bo.LoginBO;
import com.liubin.foodie.admin.pojo.bo.UserBO;
import com.liubin.foodie.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author liubin
 */
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping(Summary.USERS_PATH)
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public CommonResult usernameIsExist(@RequestParam String username) {

        // 1.判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return CommonResult.failed("用户名不能为空");
        }

        // 2.查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return CommonResult.failed("用户名已经存在");
        }

        // 3.请求成功，用户名没有重复
        return CommonResult.success();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public CommonResult<Users> register(@RequestBody @Valid UserBO userBO,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();
        // 判断密码和确认密码是否相同
        if (!password.equals(confirmPwd)) {
            return CommonResult.failed("密码和确认密码不相同");
        }

        // 密码长度不能少于6位
        if (password.length() < 6) {
            return CommonResult.failed("密码长度不能少于6");
        }

        // 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) &&
                StringUtils.isBlank(password) &&
                StringUtils.isBlank(confirmPwd)) {
            return CommonResult.failed("用户名或密码不能为空");
        }
        // 查询用户是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return CommonResult.failed("用户名已经存在");
        }
        return CommonResult.success(userService.createUser(userBO));
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public CommonResult login(@RequestBody @Valid LoginBO loginBO,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {

        String username = loginBO.getUsername();
        String password = loginBO.getPassword();

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

        setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        return CommonResult.success(userResult);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public CommonResult logout(@RequestParam String userId,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");

        return CommonResult.success();
    }

    /**
     * 清空用户信息
     *
     * @param userResult
     * @return
     */
    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setGmtCreate(null);
        userResult.setGmtUpdate(null);
        userResult.setBirthday(null);
        return userResult;
    }


}