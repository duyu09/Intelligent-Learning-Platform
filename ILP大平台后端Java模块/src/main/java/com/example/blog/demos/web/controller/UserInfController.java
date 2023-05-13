package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.UserBasicInformation;
import com.example.blog.demos.web.service.serviceimpl.UserInformationImpl;
import com.example.blog.demos.web.untils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserInfController {

    @Autowired
    UserInformationImpl userInformation;

    @TokenRequired
    @PostMapping("/getUserInformation")

    public ResponseEntity<Map<String, Object>> getUserInformation(@RequestBody Map<String, String> params) {
        Long aimUserId = Long.valueOf(params.get("aimUserId"));
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> userinformation = userInformation.getAimInformation(aimUserId);
        map.put("code", 0);
        map.put("data", userinformation);
        return ResponseEntity.ok().body(map);
    }

    @PostMapping("setUserInformation")
    public ResponseEntity<Map<String, Object>> setUserInformation(@RequestBody UserBasicInformation user) {

       Map<String,Object> result= userInformation.newUserInformation(user);
       return ResponseEntity.ok().body(result);
    }

    @TokenRequired
    @PostMapping("updataInformation")
    public ResponseEntity<Map<String,Object>> updataUserInformation(@RequestBody UserBasicInformation user ){

         Map<String,Object> result= userInformation.UpdateUserInformation(user);
         return ResponseEntity.ok().body(result);
    }
}