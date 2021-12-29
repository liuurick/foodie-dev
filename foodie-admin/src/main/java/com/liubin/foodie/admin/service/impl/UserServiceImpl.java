package com.liubin.foodie.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liubin.common.enums.DeleteEnum;
import com.liubin.common.exception.CustomException;
import com.liubin.foodie.admin.mapper.UsersMapper;
import com.liubin.foodie.admin.pojo.Users;
import com.liubin.foodie.admin.pojo.bo.UserBO;
import com.liubin.foodie.admin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;


/**
 * @author liubin
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;


//    @Override
//    public boolean queryUsernameIsExist(String username) {
//        Users user = usersMapper.selectOne(new LambdaQueryWrapper<Users>()
//                .eq(Users::getUsername, username)
//                .eq(Users::getIsDelete, DeleteEnum.NORMAL.getCode()));
//
//        return user != null;
//    }
//
//    @Override
//    public Users createUser(UserBO userBO) {
//        Users user = new Users();
//        String username = userBO.getUsername();
//        String password = userBO.getPassword();
//
//        if (!password.equals(userBO.getConfirmPassword())){
//            throw new CustomException("密码不匹配");
//        }
//        user.setUsername(username);
//        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
//        usersMapper.insert(user);
//
//        return user;
//    }
//
//    @Override
//    public Users queryUserForLogin(String username, String password) {
//
//        //Users result = usersMapper.selectOneByExample(userExample);
//        return null;
//    }
}
