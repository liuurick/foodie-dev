package com.liubin.foodie.admin.controller;

import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.foodie.admin.pojo.Users;
import com.liubin.foodie.admin.pojo.bo.UserBO;
import com.liubin.foodie.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

//    @Resource
//    private UserService userService;
//
//    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
//    @PostMapping("/register")
//    public CommonResult<Users> register(@RequestBody @Valid UserBO userBO,
//                                        HttpServletRequest request,
//                                        HttpServletResponse response) {
//        String username = userBO.getUsername();
//        String password = userBO.getPassword();
//        String confirmPwd = userBO.getConfirmPassword();
//        // 判断用户名和密码必须不为空
//        if (StringUtils.isBlank(username) ||
//                StringUtils.isBlank(password) ||
//                StringUtils.isBlank(confirmPwd)) {
//            return CommonResult.failed("用户名或密码不能为空");
//        }
//        // 查询用户是否存在
//        boolean isExist = userService.queryUsernameIsExist(username);
//        if (isExist) {
//            return CommonResult.failed("用户名已经存在");
//        }
//
//        return CommonResult.success(userService.createUser(userBO));
//    }


}