package com.liubin.service;

import com.liubin.pojo.Category;

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
}
