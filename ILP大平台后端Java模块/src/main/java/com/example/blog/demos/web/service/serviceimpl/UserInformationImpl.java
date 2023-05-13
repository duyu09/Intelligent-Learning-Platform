package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.UserRepository;
import com.example.blog.demos.web.entity.UserBasicInformation;
import com.example.blog.demos.web.service.GetUserInformation;
import com.example.blog.demos.web.untils.IdUtils;
import com.example.blog.demos.web.untils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserInformationImpl implements GetUserInformation {
  @Autowired
    UserRepository userRepository;
  @Autowired
  UserBasicInformation userBasicInformation;

    @Override
    public Map<String, Object> getAimInformation(Long aimUserId) {
        Map<String,Object> map=new HashMap<>();
         userBasicInformation=userRepository.findByUserId(aimUserId);
        map.put("userName",userBasicInformation.getUserName());
        map.put("userNickName",userBasicInformation.getUserNickname());
        map.put("userSex",userBasicInformation.getUserSex());
        map.put("userSchool",userBasicInformation.getUserSchool());
        map.put("userMajor",userBasicInformation.getUserMajor());
        map.put("userSelfIntroduction",userBasicInformation.getUserSelfIntroduction());
        map.put("userPassword",userBasicInformation.getUserPassword());
        map.put("userRegisterTime",userBasicInformation.getUserRegisterTime());
        return map;

    }

        public Map<String,Object> UpdateUserInformation(UserBasicInformation user) {
            Map<String, Object> result = new HashMap<>();
            Long userid = user.getUserId();
            Optional<UserBasicInformation> optionalUser = Optional.ofNullable(userRepository.findByUserId(userid));
            if (optionalUser.isPresent()) {
                UserBasicInformation updateUser = userRepository.findByUserId(userid);
                updateUser.setUserName(user.getUserName() == null ? updateUser.getUserName() : user.getUserName());
                updateUser.setUserNickname(user.getUserNickname() == null ? updateUser.getUserNickname() : user.getUserNickname());
                updateUser.setUserSex(user.getUserSex() == null ? updateUser.getUserSex() : user.getUserSex());
                updateUser.setUserSchool(user.getUserSchool() == null ? updateUser.getUserSchool() : user.getUserSchool());
                updateUser.setUserMajor(user.getUserMajor() == null ? updateUser.getUserMajor() : user.getUserMajor());
                updateUser.setUserSelfIntroduction(user.getUserSelfIntroduction() == null ? updateUser.getUserSelfIntroduction() : user.getUserSelfIntroduction());
                updateUser.setUserPassword(user.getUserPassword() == null ? updateUser.getUserPassword() : user.getUserPassword());
                userRepository.save(updateUser);
                result.put("code", 0);
                return result;
            }else {
                result.put("code", 2);
                return result;
            }

        }

    public Map<String,Object> newUserInformation(UserBasicInformation user) {
            Map<String, Object> result = new HashMap<>();
            userBasicInformation=userRepository.findByUserNickname(user.getUserNickname());
            if (userBasicInformation==null){
                Long userid = Long.valueOf(IdUtils.generate());
                result = new HashMap<>();
                Long newId = Long.valueOf(IdUtils.generate());
                user.setUserId(newId);
                Long userId=userRepository.save(user).getUserId();
                result.put("userId",userId);
                result.put("code",0);
                return result;
            }else {
                result.put("code",2);
                return result;
    }
    }
}





