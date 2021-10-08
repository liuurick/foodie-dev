package com.liubin.mapper;


import com.liubin.my.mapper.MyMapper;
import com.liubin.pojo.Category;
import com.liubin.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liubin
 */
@Mapper
public interface CategoryMapper extends MyMapper<Category> {

    public List<CategoryVO> getSubCatList(Integer rootCatId);
}