package com.liubin.foodie.user.controller;

import com.liubin.common.config.Summary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "忘记密码/重置密码", tags = {"忘记密码相关接口"})
@RestController
@RequestMapping(value = Summary.FORGET_RESET_PASSWORD)
public class ForgetResetPasswordRestController extends BaseRestController {

    private static final Logger logger = LoggerFactory.getLogger(LoginUserRestController.class);

    private static final String NORMAL_FORGET_PASSWORD_URL = "/normal/forget/password";
    private static final String SHORT_MESSAGE_FORGET_PASSWORD_URL = "/short/message/forget/password";
    private static final String RESET_PASSWORD_URL = "/reset/password";

    @Resource
    private ForgetPasswordService mailForgetPasswordService;

    @Resource
    private ForgetPasswordService shortMessageForgetPasswordService;

    @Resource
    private LoginUserService loginUserService;

    @ApiOperation(value = "邮箱忘记密码", notes = "正常忘记密码", httpMethod = "POST")
    @PostMapping("/info/{goodsId}")
    public BaseRestResponse forgetPassword(@RequestBody RestRequest<ForgetPasswordParam> request) {
        logger.debug("正常忘记密码");
        ForgetPasswordParam param = request.getParam();
        String loginMail = param.getLoginMail();
        this.mailForgetPasswordService.mailForgetPassword(loginMail,param.getVerificationCode(),param.getNewPassword());


        return this.createRestResponse();
    }

//    @RequestMapping(value = SHORT_MESSAGE_FORGET_PASSWORD_URL,method = RequestMethod.POST)
//    @ApiOperation(value="短信忘记密码" , notes = "根据ForgetPasswordService调用短信忘记密码方法")
//    public@ResponseBody BaseRestResponse shortMessageForgetPassword(@RequestBody RestRequest<ShortMessageForgetPasswordParam> request) {
//        logger.debug("短信忘记密码");
//        ShortMessageForgetPasswordParam param = request.getParam();
//        shortMessageForgetPasswordService.shortMessageForgetPassword(param.getLoginMobile(),param.getVerificationCode(),param.getNewPassword());
//
//        return this.createRestResponse();
//    }
//
//    @RequestMapping(value = RESET_PASSWORD_URL,method = RequestMethod.POST)
//    @ApiOperation(value="重置密码" , notes = "根据LoginUserService调用重置密码方法")
//    public@ResponseBody BaseRestResponse resetPassword(@RequestBody RestRequest<ResetPasswordParam> request) {
//        logger.debug("重置密码");
//        ResetPasswordParam param = request.getParam();
//        loginUserService.modifyPassword(param.getLoginId(),param.getNewPassword());
//
//        return this.createRestResponse();
//    }
}
