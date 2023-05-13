package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.ForumRepository;
import com.example.blog.demos.web.entity.ForumTable;
import com.example.blog.demos.web.entity.UserAimTable;
import com.example.blog.demos.web.service.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ForumImpl implements Forum {
    @Autowired
    ForumTable forum;
    Map<String,Object> result=new HashMap<>();
    @Autowired
    ForumRepository forumRepository;
    @Override
    public Map<String,Object> creatForum(String name,Long attrib) {

        ForumTable forumTable=forumRepository.findByForumName(name);
        if (forumTable==null) {
            forum.setForumName(name);
            forum.setForumAttrib(attrib);
            forumRepository.save(forum);
            Long id = forumRepository.findByForumName(name).getId();
            result.put("code", 0);
            result.put("id", id);
            return result;
        }else {
            result.put("code",2);
            return result;
        }
    }

    @Override
    public Map<String, Object> showForum() {
        List<ForumTable> forumList = forumRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        int count=forumList.size();
        for (ForumTable forum:forumList) {
            Map<String, Object> flagMap = new HashMap<>();
            flagMap.put("id",forum.getId());
            flagMap.put("name", forum.getForumName());
            flagMap.put("attrib",forum.getForumAttrib());
            data.put("forum"+count, flagMap);
            count--;
        }
        result.put("code", 0);
        result.put("data", data);
        return result;
    }
}
