package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.ParRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PsyRepository extends JpaRepository<ParRecord,Long>{
    List<ParRecord> findAllByUserId(Long userId);
}
