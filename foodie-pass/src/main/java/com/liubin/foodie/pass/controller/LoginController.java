package com.liubin.foodie.pass.controller;

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
@Api(value = "用户登录", tags = {"用于登录功能的相关接口"})
@RestController
@RequestMapping(value = Summary.PASS_LOGIN_PATH)
public class LoginController {

//    @ApiOperation(value="正常登录" , notes = "邮箱和手机+密码登录")
//    @RequestMapping(value = EMAIL_LOGIN_URL, method = RequestMethod.POST)
//    public RestResponse<LoginResult> emailLogin(@RequestBody RestRequest<NormalLoginParam> request) {
//        NormalLoginParam loginParam = request.getParam();
//        LoginResult result = loginComponent.login(loginParam);
//        return super.createRestResponse(result);
//    }

//    @ApiOperation(value = "正常登录", notes = "邮箱和手机+密码登录", httpMethod = "POST")
//    @GetMapping("/carousels")
//    @WebLog(description = "轮播图")
//    public CommonResult<LoginResult> emailLogin(@RequestBody RestRequest<NormalLoginParam> request) {
//        List<Carousel> carouselList = redisService.getCacheList("carousel");
//        if (CollectionUtils.isEmpty(carouselList)) {
//            carouselList = carouselService.queryAll(YesOrNoEnum.YES.type);
//            if (CollectionUtils.isNotEmpty(carouselList)) {
//                redisService.setCacheList("carousel", carouselList);
//            }
//        }
//        return CommonResult.success(carouselList);
//    }

//
//    @ApiOperation(value="短信验证码登录" , notes = "根据LoginComponent调用短信登录方法")
//    @RequestMapping(value = SHORT_MESSAGE_LOGIN_URL , method = RequestMethod.POST)
//    public@ResponseBody
//    RestResponse<LoginResult> shortMessageLogin(@RequestBody RestRequest<ShortMessageLoginParam> request) {
//        ShortMessageLoginParam loginParam = request.getParam();
//        LoginResult result = loginComponent.login(loginParam);
//        return super.createRestResponse(result);
//    }
//
//    @ApiOperation(value="第三方登录" , notes = "根据LoginComponent调用第三方登录方法")
//    @RequestMapping(value = THIRD_PART_LOGIN_URL , method = RequestMethod.POST)
//    public@ResponseBody RestResponse<LoginResult> thirdPartyLogin(@RequestBody RestRequest<ThirdPartyLoginParam> request) {
//        ThirdPartyLoginParam loginParam = request.getParam();
//        LoginResult result = loginComponent.login(loginParam);
//        return super.createRestResponse(result);
//    }

}
