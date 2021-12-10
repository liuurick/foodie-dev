package com.liubin.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liubin.common.enums.DeleteEnum;
import com.liubin.foodie.mapper.CategoryMapper;
import com.liubin.foodie.pojo.Category;
import com.liubin.foodie.pojo.vo.CategoryVO;
import com.liubin.foodie.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liubin
 */
@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<Category>()
                .eq(Category::getType, 1)
                .eq(Category::getIsDelete, DeleteEnum.NORMAL.getCode()));
        return categoryList;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapper.getSubCatList(rootCatId);
    }


}
