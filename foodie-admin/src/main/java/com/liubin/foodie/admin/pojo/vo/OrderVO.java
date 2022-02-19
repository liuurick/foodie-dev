package com.liubin.foodie.admin.pojo.vo;

import lombok.Data;

@Data
public class OrderVO {

    private String orderId;
    private MerchantOrdersVO merchantOrdersVO;

}