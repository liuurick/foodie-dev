package com.liubin.foodie.auth.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.liubin.common.annotation.WebLog;
import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.common.enums.YesOrNoEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liubin
 * @date 2022/3/25
 */
@Api(value = "用户注册", tags = {"用于注册功能的相关接口"})
@RestController
@RequestMapping(value = Summary.AUTH_REGISTER_PATH)
public class RegController {

//    @RequestMapping(value = MAIL_REGISTER_URL,method = RequestMethod.POST)
//    @ApiOperation(value="正常注册(邮箱注册)" , notes = "根据RegisterComponent调用正常注册方法")
//    public@ResponseBody
//    RestResponse<LoginUserRegisterResult> loginUserRegister(@RequestBody RestRequest<LoginUserRegisterParam> request) {
//        LoginUserRegisterParam registerParam = request.getParam();
//        LoginUserRegisterResult result = this.registerComponent.register(registerParam);
//        return super.createRestResponse(result);
//    }
//
//    @RequestMapping(value = SHORT_MESSAGE_REGISTER_URL,method = RequestMethod.POST)
//    @ApiOperation(value="短信验证码注册" , notes = "根据RegisterComponent调用短信注册方法")
//    public@ResponseBody RestResponse<LoginUserRegisterResult> shortMessageRegister(@RequestBody RestRequest<ShortMessageRegisterParam> request) {
//        ShortMessageRegisterParam registerParam = request.getParam();
//        LoginUserRegisterResult result = this.registerComponent.register(registerParam);
//        return super.createRestResponse(result);
//    }

}
