package top.yxf.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yxf.redis.dao.UserMapper;
import top.yxf.redis.entity.User;
import top.yxf.redis.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
