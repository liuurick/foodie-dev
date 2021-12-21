package com.liubin.foodie.admin.pojo.vo;

import lombok.Data;

/**
 * 三级分类
 * @author liubin
 */
@Data
public class SubCategoryVO {

    private Integer subId;
    private String subName;
    private String subType;
    private Integer subParentId;
}
