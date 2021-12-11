package com.liubin.foodie.service;

import com.liubin.foodie.pojo.Carousel;

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
