package com.liubin.foodie.admin.pojo.vo;

import com.liubin.foodie.admin.pojo.Goods;
import com.liubin.foodie.admin.pojo.GoodsImg;
import com.liubin.foodie.admin.pojo.GoodsParam;
import com.liubin.foodie.admin.pojo.GoodsSpec;
import lombok.Data;

import java.util.List;

/**
 * 商品详情VO
 */
@Data
public class GoodsInfoVO {

    private Goods goods;
    private List<GoodsImg> goodsImgList;
    private List<GoodsSpec> goodsSpecList;
    private GoodsParam goodsParams;
}
