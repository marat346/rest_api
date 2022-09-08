package com.calisto.spring.rest_api.service.user;

import com.calisto.spring.rest_api.DaO.user.UserDaO;
import com.calisto.spring.rest_api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDaO userDaO;

    @Override
    @Transactional
    public List<User> getAll() {
        return userDaO.getAll();
    }

    @Override
    @Transactional
    public User add(User user) {
        userDaO.add(user);
        return user;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDaO.getUser(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDaO.delete(id);
    }
}
