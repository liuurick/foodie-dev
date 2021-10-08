package com.liubin.service;

import com.liubin.pojo.Carousel;

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
    public List<Carousel> queryAll(Integer isShow);

}
