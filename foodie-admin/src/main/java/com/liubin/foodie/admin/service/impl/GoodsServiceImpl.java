package com.liubin.foodie.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liubin.common.enums.DeleteEnum;
import com.liubin.foodie.admin.mapper.GoodsImgMapper;
import com.liubin.foodie.admin.mapper.GoodsMapper;
import com.liubin.foodie.admin.mapper.GoodsParamMapper;
import com.liubin.foodie.admin.mapper.GoodsSpecMapper;
import com.liubin.foodie.admin.pojo.Goods;
import com.liubin.foodie.admin.pojo.GoodsImg;
import com.liubin.foodie.admin.pojo.GoodsParam;
import com.liubin.foodie.admin.pojo.GoodsSpec;
import com.liubin.foodie.admin.pojo.bo.GoodsInfoBO;
import com.liubin.foodie.admin.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liubin
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsImgMapper goodsImgMapper;

    @Resource
    private GoodsSpecMapper goodsSpecMapper;

    @Resource
    private GoodsParamMapper goodsParamMapper;

    @Override
    public Goods queryGoodsById(String goodsId) {
        return goodsMapper.selectOne(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getId, goodsId)
                .eq(Goods::getIsDelete, DeleteEnum.NORMAL.getCode()));
    }

    @Override
    public List<GoodsImg> queryGoodsImgList(String goodsId) {
        return goodsImgMapper.selectList(new LambdaQueryWrapper<GoodsImg>()
                .eq(GoodsImg::getGoodsId, goodsId)
                .eq(GoodsImg::getIsDelete, DeleteEnum.NORMAL.getCode()));
    }

    @Override
    public List<GoodsSpec> queryGoodsSpecList(String goodsId) {
        return goodsSpecMapper.selectList(new LambdaQueryWrapper<GoodsSpec>()
                .eq(GoodsSpec::getGoodsId, goodsId)
                .eq(GoodsSpec::getIsDelete, DeleteEnum.NORMAL.getCode()));
    }

    @Override
    public GoodsParam queryGoodsParam(String goodsId) {
        return null;
    }
}
