package com.liubin.foodie.admin.service;

import com.liubin.foodie.admin.pojo.Users;
import com.liubin.foodie.admin.pojo.bo.UserBO;

/**
 * @author liubin
 */
public interface UserService {

    /**
     * 判断用户名是否存在
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 添加用户
     */
    public Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     */
    public Users queryUserForLogin(String username, String password);
}
