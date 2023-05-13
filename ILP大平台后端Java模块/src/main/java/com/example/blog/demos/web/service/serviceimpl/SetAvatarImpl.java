package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.UserRepository;
import com.example.blog.demos.web.entity.UserBasicInformation;
import com.example.blog.demos.web.service.SetAvatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetAvatarImpl implements SetAvatar {
    @Autowired
    UserRepository userRepository;
    UserBasicInformation userBasicInformation;
    @Override
    public void setAvatar(Long userId,String imgData) {
       userBasicInformation=userRepository.findByUserId(userId);
       userBasicInformation.setUserAvatar(imgData);
       userRepository.save(userBasicInformation);

    }
}
