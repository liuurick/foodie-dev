package com.liubin.foodie.user.service;

import com.dino.registermodule.base.BaseServices;
import com.dino.registermodule.domain.entity.LoginShortMessage;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false)
public interface LoginShortMessageService extends BaseServices<LoginShortMessage> {
}
