package com.calisto.spring.rest_api.DaO.user;

import com.calisto.spring.rest_api.entity.User;

import java.util.List;

public interface UserDaO {
    public List<User> getAll();
    public User add(User user);
    public User getUser(int id);
    public void delete(int id);
}
