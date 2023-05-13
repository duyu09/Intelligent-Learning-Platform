package com.example.blog.demos.web.service;

import java.util.Map;

public interface Psy {
    public Map<String,Object> dredgePsy(Long userId, Long mode, String context);
    public Map<String,Object> showPsy(Long userId);
}
