package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.ForumTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<ForumTable,Long> {
    ForumTable findByForumAttrib(Long attrib) ;
    ForumTable findByForumName(String name);

}
