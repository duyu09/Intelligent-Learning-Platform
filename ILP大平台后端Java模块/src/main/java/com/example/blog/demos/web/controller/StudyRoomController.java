package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.StudyRoom;
import com.example.blog.demos.web.service.serviceimpl.StudyRoomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StudyRoomController {
    @Autowired
    StudyRoomImpl studyRoomImpl;
    @TokenRequired
    @PostMapping("readStudyRoom")
    public ResponseEntity<Map<String,Object>> readStudyRoom(@RequestBody Map<String,String> params){
        return ResponseEntity.ok().body(studyRoomImpl.readStudyRoom(Long.valueOf(params.get("floor"))));

    }
    @TokenRequired
    @PostMapping("startStudy")
    public ResponseEntity<Map<String,Object>> startStudy(@RequestBody StudyRoom studyRoom){
        return ResponseEntity.ok().body(studyRoomImpl.startStudy(studyRoom));
    }
    @TokenRequired
    @PostMapping("readStudyStatus")
    public ResponseEntity<Map<String,Object>> readStudyStatus(@RequestBody Map<String,String> params){
        Long userId= Long.valueOf(params.get("userId"));
        Long operation= Long.valueOf(params.get("operation"));
        return ResponseEntity.ok().body(studyRoomImpl.readStudyStatus(userId,operation));
    }
}
