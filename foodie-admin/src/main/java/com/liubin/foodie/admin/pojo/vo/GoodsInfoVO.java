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

    /**
     * 商品
     */
    private Goods goods;

    /**
     * 商品图片
     */
    private List<GoodsImg> goodsImgList;

    /**
     * 商品规格
     */
    private List<GoodsSpec> goodsSpecList;

    /**
     * 商品规格
     */
    private GoodsParam goodsParams;
}
