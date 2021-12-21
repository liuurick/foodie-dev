package com.liubin.foodie.admin.service;

import com.liubin.foodie.admin.pojo.Carousel;

import java.util.List;

/**
 * @author liubin
 */
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);

}
