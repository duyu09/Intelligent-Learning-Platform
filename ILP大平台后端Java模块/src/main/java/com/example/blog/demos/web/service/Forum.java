package com.example.blog.demos.web.service;

import com.example.blog.demos.web.entity.ForumTable;

import java.util.List;
import java.util.Map;

public interface Forum {
      public Map<String,Object> creatForum(String name, Long attrib);
      public Map<String,Object> showForum();
}
