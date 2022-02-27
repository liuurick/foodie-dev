package com.liubin.foodie.admin.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author liubin
 */
@Data
public class CartAddDTO implements Serializable {

    @NotBlank
    private String goodsId;
}
