package com.example.blog.demos.web.service;

import com.example.blog.demos.web.entity.UserAimTable;

import java.util.List;
import java.util.Map;

public interface Flag {
    public void addFlag(Long userId,String context);
    public Map<String,Object> showFlag(Long useId);
    public Map<String,Object> deleteFlag(Long userId);
}
