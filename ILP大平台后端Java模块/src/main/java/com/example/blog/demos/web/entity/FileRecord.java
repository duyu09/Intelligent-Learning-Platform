package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "file_record")
public class FileRecord {
@Id
  private long id;
  private long userId;
  private String filePath;
  private String fileName;
  private String major;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getFilePath() {return filePath;}

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

}
