package com.liubin.foodie.admin.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 三级分类
 *
 * @author liubin
 */
@Data
public class SubCategoryVO implements Serializable {

    private Integer subId;

    private String subName;

    private String subType;

    private Integer subParentId;
}
