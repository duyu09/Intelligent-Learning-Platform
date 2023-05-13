package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "sign_in_record")
public class SignInRecord {
@Id
  private long id;
  private long userId;
  private long signInTime;
  private String encourageContext;


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


  public long getSignInTime() {
    return signInTime;
  }

  public void setSignInTime(long signInTime) {
    this.signInTime = signInTime;
  }


  public String getEncourageContext() {
    return encourageContext;
  }

  public void setEncourageContext(String encourageContext) {
    this.encourageContext = encourageContext;
  }

}
