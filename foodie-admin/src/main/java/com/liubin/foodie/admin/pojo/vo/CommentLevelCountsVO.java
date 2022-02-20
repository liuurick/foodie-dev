package com.liubin.foodie.admin.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于展示商品评价数量的vo
 *
 * @author liubin
 */
@Data
public class CommentLevelCountsVO implements Serializable {

    /**
     * 总共评价总数
     */
    public Integer totalCounts;

    /**
     * 好评总数
     */
    public Integer goodCounts;

    /**
     * 中评总数
     */
    public Integer normalCounts;

    /**
     * 差评总数
     */
    public Integer badCounts;

}
