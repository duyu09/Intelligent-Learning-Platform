package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.UserAimTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface AimRepository extends JpaRepository<UserAimTable,Integer> {
     List<UserAimTable> findByUserId(Long userId);
     void deleteById(Long id);
}
