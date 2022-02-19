package com.liubin.foodie.admin.pojo.vo;

import com.liubin.foodie.admin.pojo.Goods;
import com.liubin.foodie.admin.pojo.ItemsImg;
import com.liubin.foodie.admin.pojo.GoodsParam;
import com.liubin.foodie.admin.pojo.GoodsSpec;
import lombok.Data;

import java.util.List;

/**
 * 商品详情VO
 */
@Data
public class ItemInfoVO {

    private Goods item;
    private List<ItemsImg> itemImgList;
    private List<GoodsSpec> itemSpecList;
    private GoodsParam itemParams;
}
