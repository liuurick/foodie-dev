package com.liubin.common.enums;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * @author liubin
 */
@JSONType(serializeEnumAsJavaBean = true, serializer = EnumBaseSerializer.class)
public enum GoodsStatusEnum implements ContentEnum{

    ON_SALE(0, "在线"),

    OFF(1, "下线");

    private Integer code;

    private String alias;

    GoodsStatusEnum(Integer code, String alias) {
        this.code = code;
        this.alias = alias;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getContent() {
        return this.alias;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
