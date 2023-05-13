package com.example.blog.demos.web.entity;

import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Component
@Table(name = "user_aim_table")
public class UserAimTable {
@Id
  private long id;
  private long userId;
  private String aim;
  @Column(name = "aim_set_time")

  private Long aimSetTime;



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


  public String getAim() {
    return aim;
  }

  public void setAim(String aim) {
    this.aim = aim;
  }


  public Long getAimSetTime() {
    return aimSetTime;
  }

  public void setAimSetTime(Long aimSetTime) {
    this.aimSetTime = aimSetTime;
  }

}
