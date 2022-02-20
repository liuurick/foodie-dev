package com.liubin.foodie.admin.service;

import com.liubin.foodie.admin.pojo.Goods;
import com.liubin.foodie.admin.pojo.GoodsImg;
import com.liubin.foodie.admin.pojo.GoodsParam;
import com.liubin.foodie.admin.pojo.GoodsSpec;
import com.liubin.foodie.admin.pojo.vo.CommentLevelCountsVO;

import java.util.List;

/**
 * @author liubin
 */
public interface GoodsService {

    /**
     * 根据商品id查询商品信息
     *
     * @param goodsId
     * @return
     */
    Goods queryGoodsById(String goodsId);

    /**
     * 查询商品图片列表
     *
     * @param goodsId
     * @return
     */
    List<GoodsImg> queryGoodsImgList(String goodsId);

    /**
     * 查询商品规格列表
     *
     * @param goodsId
     * @return
     */
    List<GoodsSpec> queryGoodsSpecList(String goodsId);

    /**
     * 查询商品规格参数
     *
     * @param goodsId
     * @return
     */
    GoodsParam queryGoodsParam(String goodsId);

    /**
     * 查询商品评论总数
     *
     * @param goodsId
     * @return
     */
    CommentLevelCountsVO queryCommentCounts(String goodsId);
}
