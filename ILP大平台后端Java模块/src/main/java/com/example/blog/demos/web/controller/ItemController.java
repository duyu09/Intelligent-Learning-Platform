package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.service.serviceimpl.ItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
      public class ItemController {
            @Autowired
            ItemImpl itemImpl;
            @TokenRequired
            @PostMapping("releaseItem")
      public ResponseEntity<Map<String,Object>> releaseItem(@RequestBody Map<String,String> params){
                Long userId= Long.valueOf(params.get("userId"));
                Long forumId= Long.valueOf(params.get("forumId"));
                String context=params.get("context");
        return ResponseEntity.ok().body(itemImpl.releaseItem(userId,forumId,context));
    }
    @TokenRequired
    @PostMapping("showItem")
      public ResponseEntity<Map<String,Object>> showItem(@RequestBody Map<String,String> params){
                Long forumId= Long.valueOf(params.get("forumId"));
                return ResponseEntity.ok().body(itemImpl.showItem(forumId));
    }
    @TokenRequired
    @PostMapping("deleteItem")
      public ResponseEntity<Map<String,Object>> deleteItem(@RequestBody Map<String,String> params){
                Integer id= Integer.valueOf(params.get("Id"));
                Long userId= Long.valueOf(params.get("userId"));
                return ResponseEntity.ok().body( itemImpl.deleteItem(id,userId));
    }
    @TokenRequired
    @PostMapping("upvote")
      public ResponseEntity<Map<String,Object>> upvote(@RequestBody Map<String,String> params){
                Long id= Long.valueOf(params.get("id"));
                return ResponseEntity.ok().body(itemImpl.upvote(id));
    }


}
