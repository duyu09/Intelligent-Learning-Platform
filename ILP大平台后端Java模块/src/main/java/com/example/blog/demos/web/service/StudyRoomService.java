package com.example.blog.demos.web.service;

import com.example.blog.demos.web.entity.StudyRoom;

import java.util.Map;

public interface StudyRoomService {
        public Map<String,Object> readStudyRoom(Long floor);
        public Map<String,Object> startStudy(StudyRoom studyRoom);
        public Map<String,Object> readStudyStatus(Long userId,Long operation);
}
