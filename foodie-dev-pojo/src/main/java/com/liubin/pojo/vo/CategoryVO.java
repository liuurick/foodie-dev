package com.liubin.pojo.vo;

import lombok.Data;
import java.util.List;

/**
 * 二级分类
 * @author liubin
 */
@Data
public class CategoryVO {

    private Integer id;
    private String name;
    private String type;
    private Integer parentId;

    /**
     * 三级分类vo list
      */
    private List<SubCategoryVO> subCatList;
}
