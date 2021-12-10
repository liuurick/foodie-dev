package com.liubin.common.enums;

import com.alibaba.fastjson.annotation.JSONType;


/**
 * @author liubin
 * @date 2021/11/11
 */
@JSONType(serializeEnumAsJavaBean = true, serializer = EnumBaseSerializer.class)
public enum DeleteEnum implements ContentEnum {

    NORMAL(0, "正常"),

    DELETE(1, "删除");

    private Integer code;

    private String alias;

    DeleteEnum(Integer code, String alias) {
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
