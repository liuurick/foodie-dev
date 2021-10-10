package com.liubin.service.impl;

import com.liubin.mapper.CategoryMapper;
import com.liubin.pojo.Category;
import com.liubin.pojo.vo.CategoryVO;
import com.liubin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liubin
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria categoryCriteria = example.createCriteria();
        categoryCriteria.andEqualTo("type", 1);
        List<Category> categoryList = categoryMapper.selectByExample(example);
        return categoryList;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapper.getSubCatList(rootCatId);
    }


}
