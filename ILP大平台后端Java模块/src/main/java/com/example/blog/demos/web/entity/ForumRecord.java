package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "forum_record")
public class ForumRecord {
@Id
  private long id;
  private long attrib;
  private long forumId;
  private long floor;
  private String itemContext;
  private long publishTime;
  private long publishUserId;
  private Long upvote;




  public Long getUpvote() {return upvote;}

  public void setUpvote(long upvote) {this.upvote = upvote;}

  public void setPublishUserId(long publishUserId){
       this.publishUserId=publishUserId;
     }
  public long getPublishUserId(){
  return publishUserId;
  }
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAttrib() {
    return attrib;
  }

  public void setAttrib(long attrib) {
    this.attrib = attrib;
  }


  public long getForumId() {
    return forumId;
  }

  public void setForumId(long forumId) {
    this.forumId = forumId;
  }


  public long getFloor() {
    return floor;
  }

  public void setFloor(long floor) {
    this.floor = floor;
  }


  public String getItemContext() {
    return itemContext;
  }

  public void setItemContext(String itemContext) {
    this.itemContext = itemContext;
  }


  public long getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Long publishTime) {
    this.publishTime = publishTime;
  }

}
