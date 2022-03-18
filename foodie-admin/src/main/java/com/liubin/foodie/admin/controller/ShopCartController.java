package com.liubin.foodie.admin.controller;

import com.liubin.common.annotation.WebLog;
import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.foodie.admin.pojo.bo.ShopCartBO;
import com.liubin.foodie.admin.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Redis高性能实现购物车
 *
 * @author liubin
 * @date 2022/2/17
 */
@Api(value = "购物车", tags = {"购物车相关接口"})
@RestController
@RequestMapping(value = Summary.SHOP_CART_PATH)
public class ShopCartController {

    @Resource
    private CartService cartService;

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @GetMapping("/add")
    @WebLog(description = "添加商品到购物车")
    public CommonResult add(@RequestParam String userId,
                            @RequestBody ShopCartBO shopCartBO,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        return CommonResult.success();
    }

//    @GetMapping("/list")
//    public CommonResult<CartVo> list(HttpSession session) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.list(user.getId());
//    }
//
//    @PutMapping("/{goodsId}")
//    public CommonResult<CartVo> update(@PathVariable Integer goodsId,
//                                     @Valid @RequestBody CartUpdateForm form,
//                                     HttpSession session, @PathVariable String goodsId) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.update(user.getId(), productId, form);
//    }
//
//    @DeleteMapping("/{goodsId}")
//    public CommonResult<CartVo> delete(@PathVariable Integer goodsId,
//                                     HttpSession session) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.delete(user.getId(), productId);
//    }
//
//    @PutMapping("/carts/selectAll")
//    public CommonResult<CartVo> selectAll(HttpSession session) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.selectAll(user.getId());
//    }
//
//    @PutMapping("/carts/unSelectAll")
//    public CommonResult<CartVo> unSelectAll(HttpSession session) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.unSelectAll(user.getId());
//    }
//
//    @GetMapping("/products/sum")
//    public CommonResult<Integer> sum(HttpSession session) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.sum(user.getId());
//    }

}
