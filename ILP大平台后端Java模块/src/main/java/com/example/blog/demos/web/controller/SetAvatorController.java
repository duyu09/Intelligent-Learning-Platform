package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.service.serviceimpl.GetAvatarImpl;
import com.example.blog.demos.web.service.serviceimpl.SetAvatarImpl;
import com.example.blog.demos.web.untils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class SetAvatorController {

    @Autowired
    private SetAvatarImpl setAvatar;
    @TokenRequired
    @PostMapping("/setAvatar")
    public ResponseEntity<Map<String,Object>> getAvator(@RequestBody Map<String,String> params) throws NoSuchAlgorithmException {
        Long userId = Long.valueOf(params.get("userId"));
        String imgData = params.get("imgData");
        Map<String,Object> map=new HashMap<>();
        setAvatar.setAvatar(userId,imgData);
        map.put("code",0);
        return ResponseEntity.ok().body(map);
    }
}