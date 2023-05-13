package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.SignInRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<SignInRecord,Long>{
    SignInRecord findByUserId(Long userId);
}