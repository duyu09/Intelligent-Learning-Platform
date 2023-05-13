package com.example.blog;

import com.example.blog.demos.web.service.serviceimpl.ForumImpl;
import com.example.blog.demos.web.untils.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
;

public class test {
    @Test
     void test1(){

        IdUtils idUtils=new IdUtils();
        System.out.println(idUtils.generate());
    }
    @Autowired
    ForumImpl forum;
    @Test
    void test2(){

        forum.showForum();
    }
}
