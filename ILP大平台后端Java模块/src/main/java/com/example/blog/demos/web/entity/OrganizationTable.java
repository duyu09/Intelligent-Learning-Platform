package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "organization_table")
public class OrganizationTable {
@Id
  private long id;
  private String orgName;
  private long orgAttrib;
  private String orgDescription;
  private long orgAddTime;
  private String orgRecruitment;

  public String getOrgRecruitment() {
    return orgRecruitment;
  }

  public void setOrgRecruitment(String orgRecruitment) {
    this.orgRecruitment = orgRecruitment;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }


  public long getOrgAttrib() {
    return orgAttrib;
  }

  public void setOrgAttrib(long orgAttrib) {
    this.orgAttrib = orgAttrib;
  }


  public String getOrgDescription() {
    return orgDescription;
  }

  public void setOrgDescription(String orgDescription) {
    this.orgDescription = orgDescription;
  }


  public long getOrgAddTime() {
    return orgAddTime;
  }

  public void setOrgAddTime(long orgAddTime) {
    this.orgAddTime = orgAddTime;
  }

}
