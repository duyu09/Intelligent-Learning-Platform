package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.UserRepository;
import com.example.blog.demos.web.service.GetAvatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAvatarImpl implements GetAvatar {
  @Autowired
  private   UserRepository userRepository;
    public String getImgData(Long aimUserId){

    return userRepository.findByUserId(aimUserId).getUserAvatar();
    }
}
