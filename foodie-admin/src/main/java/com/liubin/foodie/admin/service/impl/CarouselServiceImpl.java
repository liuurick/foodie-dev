package com.liubin.foodie.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liubin.common.enums.DeleteEnum;
import com.liubin.foodie.admin.mapper.CarouselMapper;
import com.liubin.foodie.admin.pojo.Carousel;
import com.liubin.foodie.admin.service.CarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liubin
 */
@Service("carouselServiceImpl")
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        return carouselMapper.selectList(new LambdaQueryWrapper<Carousel>()
                .eq(Carousel::getIsShow, isShow)
                .eq(Carousel::getIsDelete, DeleteEnum.NORMAL.getCode()));
    }
}
