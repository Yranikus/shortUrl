package com.task.shortUrl.configuration.UserDetailService;

import com.task.shortUrl.DAO.UserDao;
import com.task.shortUrl.models.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {

        try {
            UserEntity user = userDao.findByLogin(login);
            if (user != null) {
                UserDetails userman = User.withUsername(user.getLogin()).password(user.getPassword())
                        .roles(user.getRole())
                        .build();
                return userman;
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        throw new UsernameNotFoundException(login);
    }


}
