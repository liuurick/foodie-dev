package com.liubin.foodie.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.liubin.common.annotation.WebLog;
import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.common.enums.YesOrNoEnum;
import com.liubin.foodie.admin.pojo.Carousel;
import com.liubin.foodie.admin.pojo.bo.ShopCartBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author liubin
 * @date 2022/2/17
 */
@Api(value = "购物车", tags = {"购物车相关接口"})
@RestController
@RequestMapping(value = Summary.SHOP_CART_PATH)
public class ShopCartController {

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @GetMapping("/add")
    @WebLog(description = "添加商品到购物车")
    public CommonResult add(@RequestParam String userId,
                            @RequestBody ShopCartBO shopCartBO,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        return CommonResult.success();
    }


}
