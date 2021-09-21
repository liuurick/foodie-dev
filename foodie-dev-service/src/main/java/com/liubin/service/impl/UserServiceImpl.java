package com.liubin.service.impl;

import com.liubin.mapper.UsersMapper;
import com.liubin.pojo.BO.UserBO;
import com.liubin.pojo.Users;
import com.liubin.service.UserService;
import org.n3r.idworker.Sid;
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

    @Autowired
    private Sid sid;

    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andCondition(username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }

    @Override
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        String userId = sid.nextShort();
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        user.setId(userId);
        user.setUsername(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        usersMapper.insert(user);

        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        return null;
    }
}
