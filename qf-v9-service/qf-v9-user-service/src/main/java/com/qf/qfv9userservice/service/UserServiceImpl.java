package com.qf.qfv9userservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.api.user.IUserService;
import com.qf.jpa.repository.UserRepository;
import com.qf.v9.entity.DO.TUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import java.util.UUID;


@Component
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TUserDO checkLogin(TUserDO user) {

        //查询数据库有没有这个数据
        TUserDO currentUser = userRepository.findByUserName(user.getUsername());

        if(currentUser!=null){
            if(passwordEncoder.matches(user.getPassword(),currentUser.getPassword())) {
                return currentUser;
            }
        }

        return null;
    }
}
