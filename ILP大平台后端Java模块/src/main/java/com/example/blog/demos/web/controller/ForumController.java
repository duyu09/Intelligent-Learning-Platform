package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.service.serviceimpl.ForumImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ForumController {
    @Autowired
    ForumImpl forum;

    @TokenRequired
    @PostMapping("creatForum")
    public ResponseEntity<Map<String,Object>> creatForum(@RequestBody Map<String,String> params){
            Long attrib= Long.valueOf(params.get("attrib"));
            String name=params.get("name");
            Map<String,Object> result=forum.creatForum(name,attrib);
            return ResponseEntity.ok().body(result);
}
    @TokenRequired
    @PostMapping("showForum")
    public ResponseEntity<Map<String,Object>> showForum(){
      return ResponseEntity.ok().body(forum.showForum());
    }
}
