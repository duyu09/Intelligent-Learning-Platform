package com.example.blog.demos.web.service;

import java.util.Map;

public interface Sign {
        public Map<String,Object> signIn(Long userId,String context);
        public Map<String,Object> readSignContext(Long userId);
        public void deleteSign();
}
