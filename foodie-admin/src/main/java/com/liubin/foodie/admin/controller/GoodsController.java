package com.liubin.foodie.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.foodie.admin.pojo.Goods;
import com.liubin.foodie.admin.pojo.GoodsImg;
import com.liubin.foodie.admin.pojo.GoodsParam;
import com.liubin.foodie.admin.pojo.GoodsSpec;
import com.liubin.foodie.admin.pojo.vo.CommentLevelCountsVO;
import com.liubin.foodie.admin.pojo.vo.GoodsInfoVO;
import com.liubin.foodie.admin.pojo.vo.ShopcartVO;
import com.liubin.foodie.admin.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liubin
 */
@Api(value = "商品管理", tags = {"商品相关接口"})
@RestController
@RequestMapping(value = Summary.GOODS_PATH)
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{goodsId}")
    public CommonResult<GoodsInfoVO> info(
            @ApiParam(name = "goodsId", value = "商品id", required = true)
            @PathVariable String goodsId) {

        if (StringUtils.isBlank(goodsId)) {
            return CommonResult.failed("商品id不能为空");
        }

        Goods goods = goodsService.queryGoodsById(goodsId);
        List<GoodsImg> itemImgList = goodsService.queryGoodsImgList(goodsId);
        List<GoodsSpec> itemsSpecList = goodsService.queryGoodsSpecList(goodsId);
        GoodsParam goodsParam = goodsService.queryGoodsParam(goodsId);

        GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
        goodsInfoVO.setGoods(goods);
        goodsInfoVO.setGoodsImgList(itemImgList);
        goodsInfoVO.setGoodsSpecList(itemsSpecList);
        goodsInfoVO.setGoodsParams(goodsParam);

        return CommonResult.success(goodsInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public CommonResult commentLevel(
            @ApiParam(name = "goodsId", value = "商品id", required = true)
            @RequestParam String goodsId) {

        if (StringUtils.isBlank(goodsId)) {
            return CommonResult.failed("商品id不能为空");
        }

        CommentLevelCountsVO countsVO = goodsService.queryCommentCounts(goodsId);

        return CommonResult.success(countsVO);
    }

//    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
//    @GetMapping("/comments")
//    public CommonResult comments(
//            @ApiParam(name = "goodsId", value = "商品id", required = true)
//            @RequestParam String goodsId,
//            @ApiParam(name = "level", value = "评价等级", required = false)
//            @RequestParam Integer level) {
//
//        if (StringUtils.isBlank(goodsId)) {
//            return CommonResult.failed("商品id不能为空");
//        }
//
//        return CommonResult.success(grid);
//    }

    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @GetMapping("/search")
    public CommonResult search(
            @ApiParam(name = "keywords", value = "关键字", required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort", value = "排序", required = false)
            @RequestParam String sort) {

        if (StringUtils.isBlank(keywords)) {
            return CommonResult.failed("查询关键字不能为空");
        }

        return CommonResult.success();
    }

//    @ApiOperation(value = "通过分类id搜索商品列表", notes = "通过分类id搜索商品列表", httpMethod = "GET")
//    @GetMapping("/catItems")
//    public CommonResult catItems(
//            @ApiParam(name = "catId", value = "三级分类id", required = true)
//            @RequestParam Integer catId,
//            @ApiParam(name = "sort", value = "排序", required = false)
//            @RequestParam String sort,
//            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
//            @RequestParam Integer page,
//            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
//            @RequestParam Integer pageSize) {
//
//        if (catId == null) {
//            return CommonResult.failed("三级分类id不能为空");
//        }
//
//        if (page == null) {
//            page = 1;
//        }
//
//        if (pageSize == null) {
//            pageSize = PAGE_SIZE;
//        }
//
//        PagedGridResult grid = itemService.searhItems(catId,
//                sort,
//                page,
//                pageSize);
//
//        return CommonResult.success(grid);
//    }

    /**
     * 用于用户长时间未登录网站，刷新购物车中的数据（主要是商品价格），类似京东淘宝
     */
//    @ApiOperation(value = "根据商品规格ids查找最新的商品数据", notes = "根据商品规格ids查找最新的商品数据", httpMethod = "GET")
//    @GetMapping("/refresh")
//    public CommonResult refresh(
//            @ApiParam(name = "itemSpecIds", value = "拼接的规格ids", required = true, example = "1001,1003,1005")
//            @RequestParam String itemSpecIds) {
//
//        if (StringUtils.isBlank(itemSpecIds)) {
//            return CommonResult.success();
//        }
//
//        List<ShopcartVO> list = goodsService.queryGoodsBySpecIds(itemSpecIds);
//
//        return CommonResult.success(list);
//    }
}
