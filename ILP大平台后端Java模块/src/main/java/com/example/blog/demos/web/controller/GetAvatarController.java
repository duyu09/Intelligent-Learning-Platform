package com.example.blog.demos.web.controller;
import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.service.serviceimpl.GetAvatarImpl;

import com.example.blog.demos.web.untils.TokenUtils;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class GetAvatarController {
    Map<String,Object> result=new HashMap<>();
    @Autowired
   private GetAvatarImpl getAvatar;
    @PostMapping ("/getAvatar")
    @TokenRequired
    public ResponseEntity<Map<String,Object>> getAvatar(@RequestBody Map<String,String> params) {
        Long aimUserId= Long.valueOf(params.get("aimUserId"));
        result.put("code",0);
        result.put("imgData",getAvatar.getImgData(aimUserId));
        return ResponseEntity.ok().body(result);
    }
}
