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
    public List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    public List<CategoryVO> getSubCatList(Integer rootCatId);
}
