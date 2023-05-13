package com.example.blog.demos.web.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity   //表示这个类是一个实体类
@Table(name = "user_basic_information")    //对
public class UserBasicInformation
{
  @Id
 private long id;
  private long userId;

  private String userName;

  private String userNickname;
  private Long userSex;
  private String userSchool;
  private String userMajor;


  private String userSelfIntroduction;

  private String userAvatar;

  private String userPassword;
  private long userRegisterTime;

 public String getUserPassword() {
  return userPassword;
 }

 public Long getUserId() {
  return userId;
 }

    public String getUserName() {
        return userName;
    }

 public String getUserNickname() {
  return userNickname;
 }

 public Long getUserSex() {
  return userSex;
 }

 public String getUserSchool() {
  return userSchool;
 }

 public String getUserMajor() {
  return userMajor;
 }

 public String getUserSelfIntroduction() {
  return userSelfIntroduction;
 }

 public Long getUserRegisterTime() {
  return userRegisterTime;
 }

 public void setUserName(String userName) {
  this.userName = userName;
 }

 public void setUserNickname(String userNickname) {
  this.userNickname = userNickname;
 }

 public void setUserSex(Long userSex) {
  this.userSex = userSex;
 }

 public void setUserSchool(String userSchool) {
  this.userSchool = userSchool;
 }

 public void setUserMajor(String userMajor) {
  this.userMajor = userMajor;
 }

 public void setUserSelfIntroduction(String userSelfIntroduction) {
  this.userSelfIntroduction = userSelfIntroduction;
 }

 public void setUserPassword(String userPassword) {
  this.userPassword = userPassword;
 }

 public void setUserId(Long userId) {
  this.userId = userId;
 }

 public String getUserAvatar() {
  return userAvatar;
 }

 public void setUserAvatar(String avatar) {
  this.userAvatar=avatar;

 }
}



