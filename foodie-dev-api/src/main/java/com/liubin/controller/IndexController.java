package com.liubin.controller;

import com.liubin.common.enums.YesOrNoEnum;
import com.liubin.common.utils.IMOOCJSONResult;
import com.liubin.pojo.Carousel;
import com.liubin.pojo.Category;
import com.liubin.service.CarouselService;
import com.liubin.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liubin
 */
@Api(value = "首页展示", tags = {"用于首页展示的相关接口"})
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "轮播图", notes = "轮播图", httpMethod = "GET")
    @GetMapping("/carousels")
    public IMOOCJSONResult carousel() {

        List<Carousel> carousels = carouselService.queryAll(YesOrNoEnum.YES.type);

        return IMOOCJSONResult.ok(carousels);
    }

    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类，渲染展示到首页
     * 2. 如果鼠标上移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载（懒加载）
     */
    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/categorys")
    public IMOOCJSONResult cats() {
        List<Category> list = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat() {

        return IMOOCJSONResult.ok();
    }
}
