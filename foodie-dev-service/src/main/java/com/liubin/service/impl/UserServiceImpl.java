package com.liubin.service.impl;

import com.liubin.common.exception.CustomException;
import com.liubin.mapper.UsersMapper;
import com.liubin.pojo.bo.UserBO;
import com.liubin.pojo.Users;
import com.liubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;


/**
 * @author liubin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);

        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }

    @Override
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        if (!password.equals(userBO.getConfirmPassword())){
            throw new CustomException("密码不匹配");
        }
        user.setUsername(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        usersMapper.insert(user);

        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }
}
