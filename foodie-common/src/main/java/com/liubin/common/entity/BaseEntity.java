package com.liubin.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Entity基类
 * 
 * @author liubin
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 是否删除:0:正常,1删除
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_update")
    private Date gmtUpdate;


    /**
     * 创建者id
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 更新者id
     */
    @TableField("update_by")
    private Long updateBy;
}
