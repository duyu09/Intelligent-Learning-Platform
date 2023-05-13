package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.ForumRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRecordRepository extends JpaRepository<ForumRecord, Long> {
        List<ForumRecord> findAllByForumId(Long forumId);
        ForumRecord findById(long id);
}
