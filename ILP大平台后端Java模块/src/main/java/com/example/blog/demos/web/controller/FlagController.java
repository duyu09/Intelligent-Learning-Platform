package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.UserAimTable;
import com.example.blog.demos.web.service.serviceimpl.FlagImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin(origins = "*")
public class FlagController {
    @Autowired
    FlagImpl flagimpl;

    @TokenRequired
    @PostMapping("addFlag")
    public ResponseEntity<Map<String,Object>> addFlag(@RequestBody Map<String,String> params){
            Map<String,Object> result=new HashMap<>();
            Long userId= Long.valueOf(params.get("userId"));
            String context=params.get("context");
            flagimpl.addFlag(userId,context);
            result.put("code",0);
        return ResponseEntity.ok().body(result);

    }
    @TokenRequired
    @PostMapping("showFlag")

    public ResponseEntity<Map<String,Object>> showFlag(@RequestBody Map<String,String> map) {
        Long userId = Long.valueOf(map.get("aimUserId"));
        System.out.println(userId);
        return ResponseEntity.ok().body(flagimpl.showFlag(userId)) ;
    }
    @Transactional
    @TokenRequired
    @PostMapping("deleteFlag")
    public ResponseEntity<Map<String, Object>> deleteFlag(@RequestBody Map<String,String> params){
        Long Id = Long.valueOf(params.get("id"));
        return ResponseEntity.ok().body(flagimpl.deleteFlag(Id));
    }

}
