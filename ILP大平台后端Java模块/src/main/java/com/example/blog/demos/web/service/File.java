package com.example.blog.demos.web.service;

import com.example.blog.demos.web.entity.FileRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface File {
    public Map<String,Object> upload(MultipartFile file,Long userId,String fileName,String major);
}
