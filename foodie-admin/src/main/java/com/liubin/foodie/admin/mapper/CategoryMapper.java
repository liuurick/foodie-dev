package com.liubin.foodie.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liubin.foodie.admin.pojo.Category;
import com.liubin.foodie.admin.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liubin
 * @date 2021/12/10
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    List<CategoryVO> getSubCatList(@Param("rootCatId") Integer rootCatId);
}
