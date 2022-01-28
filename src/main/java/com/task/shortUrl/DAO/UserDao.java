package com.task.shortUrl.DAO;

import com.task.shortUrl.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(UserEntity userEntity){
        jdbcTemplate.update("INSERT INTO USERS(login, password, role) VALUES(?,?,?)", userEntity.getLogin(),
                userEntity.getPassword(),userEntity.getPassword());
    }

    public UserEntity findByLogin(String login){
        return jdbcTemplate.query("SELECT * FROM USERS WHERE login=?", new Object[]{login}, new BeanPropertyRowMapper<>(UserEntity.class)).stream().findAny().orElse(null);
    }



}
