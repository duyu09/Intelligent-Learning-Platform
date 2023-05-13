package com.example.blog.demos.web.service;

import java.util.Map;

public interface Item {
    public Map<String,Object> releaseItem(Long userId,Long attrib,String context);

    public Map<String,Object> showItem(Long forumId);

    public Map<String, Object> deleteItem(long id, Long userId);
    public Map<String,Object>   upvote(Long id);


}
