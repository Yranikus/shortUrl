package com.task.shortUrl.service;

import com.task.shortUrl.DAO.UserDao;
import com.task.shortUrl.models.UserEntity;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(String login, String password) {
        UserEntity userEntity = userDao.findByLogin(login);
        if( userEntity == null ){
            userEntity = new UserEntity();
            userEntity.setLogin(login);
            userEntity.setPassword(passwordEncoder.encode(password));
            userEntity.setRole("USER");
            userDao.save(userEntity);
            return true;
        }
        return false;
    }



}
