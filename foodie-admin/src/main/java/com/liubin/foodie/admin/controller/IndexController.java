package com.liubin.foodie.admin.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.google.common.collect.Lists;
import com.liubin.common.annotation.WebLog;
import com.liubin.common.api.CommonResult;
import com.liubin.common.config.Summary;
import com.liubin.common.enums.YesOrNoEnum;
import com.liubin.common.utils.redis.RedisService;
import com.liubin.foodie.admin.pojo.Carousel;
import com.liubin.foodie.admin.pojo.Category;
import com.liubin.foodie.admin.pojo.vo.CategoryVO;
import com.liubin.foodie.admin.service.CarouselService;
import com.liubin.foodie.admin.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author liubin
 */
@Api(value = "首页展示", tags = {"用于首页展示的相关接口"})
@RestController
@RequestMapping(value = Summary.INDEX_PATH)
public class IndexController {

    @Resource
    private CarouselService carouselService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private RedisService redisService;

    @ApiOperation(value = "轮播图", notes = "轮播图", httpMethod = "GET")
    @GetMapping("/carousels")
    @WebLog(description = "轮播图")
    public CommonResult<List<Carousel>> carousel() {
        List<Carousel> carouselList = redisService.getCacheList("carousel");
        if (CollectionUtils.isEmpty(carouselList)) {
            carouselList = carouselService.queryAll(YesOrNoEnum.YES.type);
            if (CollectionUtils.isNotEmpty(carouselList)) {
                redisService.setCacheList("carousel", carouselList);
            }
        }
        return CommonResult.success(carouselList);
    }

    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类，渲染展示到首页
     * 2. 如果鼠标上移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载（懒加载）
     */
    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/categorys")
    @WebLog(description = "获取商品分类(一级分类)")
    public CommonResult<List<Category>> cats() {
        return CommonResult.success(categoryService.queryAllRootLevelCat());
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    @WebLog(description = "获取商品子分类")
    public CommonResult<List<CategoryVO>> subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (ObjectUtils.isNull(rootCatId)) {
            return CommonResult.failed("分类不存在");
        }
        return CommonResult.success(categoryService.getSubCatList(rootCatId));
    }
}
