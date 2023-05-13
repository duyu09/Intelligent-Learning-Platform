package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.service.serviceimpl.SignImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.ImageProducer;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class SignController {
    @Autowired
    SignImpl signIn;
     @TokenRequired
     @PostMapping("signIn")
     public ResponseEntity<Map<String,Object>> SignIn(@RequestBody Map<String,String> params){
         Long userId= Long.valueOf(params.get("userId"));
         String context=params.get("context");
         return ResponseEntity.ok().body(signIn.signIn(userId,context));
     }
     @TokenRequired
     @PostMapping("readSignInContext")
     public ResponseEntity<Map<String,Object>> readSignInContext(@RequestBody Map<String,String> params){
         Long userId= Long.valueOf(params.get("userId"));
         return ResponseEntity.ok().body(signIn.readSignContext(userId));
     }
}
