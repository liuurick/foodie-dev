package com.liubin.foodie.admin.pojo.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 购物车对象
 * @author liubin
 * @date 2022/2/17
 */
@ApiModel(value = "购物车对象BO", description = "从客户端，由用户传入的数据封装在此entity中")
@Data
public class ShopCartBO implements Serializable {

}
