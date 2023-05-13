package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.AbilityTestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTestRepository extends JpaRepository<AbilityTestRecord,Long> {

}
