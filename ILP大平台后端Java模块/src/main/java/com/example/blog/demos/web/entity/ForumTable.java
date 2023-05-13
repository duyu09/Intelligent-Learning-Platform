package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name ="forum_table")
public class ForumTable {
@Id
  private long id;
  private String forumName;
  private long forumAttrib;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getForumName() {
    return forumName;
  }

  public void setForumName(String forumName) {
    this.forumName = forumName;
  }


  public long getForumAttrib() {
    return forumAttrib;
  }

  public void setForumAttrib(long forumAttrib) {
    this.forumAttrib = forumAttrib;
  }

}
