package com.liubin.foodie.admin.service;

import com.liubin.foodie.admin.pojo.Category;
import com.liubin.foodie.admin.pojo.vo.CategoryVO;

import java.util.List;

/**
 * @author liubin
 */
public interface CategoryService {

    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);
}
