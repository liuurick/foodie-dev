package com.liubin.common.enums;

import lombok.Getter;

/**
 * 用户会话,状态
 *
 * @author liubin
 */
@Getter
public enum OnlineStatus {

    ON_LINE("在线"),

    OFF_LINE("离线");

    private final String info;

    private OnlineStatus(String info) {
        this.info = info;
    }

}
