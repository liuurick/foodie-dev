package com.liubin.foodie.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liubin.foodie.admin.pojo.Category;
import com.liubin.foodie.admin.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liubin
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
