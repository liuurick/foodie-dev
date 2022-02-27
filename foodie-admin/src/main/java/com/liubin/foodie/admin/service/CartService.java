package com.liubin.foodie.admin.service;

import com.liubin.common.api.CommonResult;

/**
 * @author liubin
 */
public interface CartService {

    CommonResult<CartVo> add(String uid, CartAddForm form);

    CommonResult<CartVo> list(Integer uid);

    CommonResult<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    CommonResult<CartVo> delete(Integer uid, Integer productId);

    CommonResult<CartVo> selectAll(Integer uid);

    CommonResult<CartVo> unSelectAll(Integer uid);

    CommonResult<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
