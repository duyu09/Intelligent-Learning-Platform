package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "par_record")

public class ParRecord {
@Id
  private long id;
  private long userId;
  private long parMode;
  private String inputContext;
  private String outputContext;
  private long parTime;


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


  public long getParMode() {
    return parMode;
  }

  public void setParMode(long parMode) {
    this.parMode = parMode;
  }


  public String getInputContext() {
    return inputContext;
  }

  public void setInputContext(String inputContext) {
    this.inputContext = inputContext;
  }


  public String getOutputContext() {
    return outputContext;
  }

  public void setOutputContext(String outputContext) {
    this.outputContext = outputContext;
  }


  public long getParTime() {
    return parTime;
  }

  public void setParTime(long parTime) {
    this.parTime = parTime;
  }

}
