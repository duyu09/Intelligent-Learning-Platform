package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "study_room")
public class StudyRoom {
@Id
  private Long id;
  private Long userId;
  private Long floor;
  private Long site;
  private Long startTime;
  private String context;
  private String encourage;
  private Long length;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public Long getFloor() {
    return floor;
  }

  public void setFloor(Long floor) {
    this.floor = floor;
  }


  public Long getSite() {
    return site;
  }

  public void setSite(Long site) {
    this.site = site;
  }


  public Long getStartTime() {
    return startTime;
  }

  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }


  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }


  public String getEncourage() {
    return encourage;
  }

  public void setEncourage(String encourage) {
    this.encourage = encourage;
  }


  public Long getLength() {
    return length;
  }

  public void setLength(Long length) {
    this.length = length;
  }

}
