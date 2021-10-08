package com.liubin.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 三级分类
 * @author liubin
 */
@Getter
@Setter
public class SubCategoryVO {

    private Integer subId;
    private String subName;
    private String subType;
    private Integer subFatherId;
}
