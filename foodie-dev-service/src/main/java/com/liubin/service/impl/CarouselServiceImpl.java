package com.liubin.service.impl;

import com.liubin.mapper.CarouselMapper;
import com.liubin.pojo.Carousel;
import com.liubin.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liubin
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria carouselCriteria = example.createCriteria();
        carouselCriteria.andEqualTo("isShow", isShow);

        List<Carousel> result = carouselMapper.selectByExample(example);

        return result;
    }
}
