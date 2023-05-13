package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.FileRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FileRecordRepository extends JpaRepository<FileRecord,Long> {
    FileRecord findByFilePath(String path);
    Optional<FileRecord> findById(Long id);
}
