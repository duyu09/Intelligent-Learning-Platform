package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.UserRepository;
import com.example.blog.demos.web.entity.UserBasicInformation;
import com.example.blog.demos.web.service.LoginService;
import com.example.blog.demos.web.untils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtils tokenService;
    public boolean isValidUser(Integer username, String password) {
  UserBasicInformation user = userRepository.findByUserId(username);
        if (user == null) {
            return false;
        } else {
            return user.getUserPassword().equals(password);
        }
    }


}