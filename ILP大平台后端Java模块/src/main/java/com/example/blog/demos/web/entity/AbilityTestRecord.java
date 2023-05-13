package com.example.blog.demos.web.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "ability_test_record")
public class AbilityTestRecord {
@Id
  private long id;
  private long userId;
  private String inputContext;
  private long salary;
  private String diff;
  private long workMode;
  private long expectSalary;
  private String expectCity;


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


  public String getInputContext() {
    return inputContext;
  }

  public void setInputContext(String inputContext) {
    this.inputContext = inputContext;
  }


  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }


  public String getDiff() {
    return diff;
  }

  public void setDiff(String diff) {
    this.diff = diff;
  }


  public long getWorkMode() {
    return workMode;
  }

  public void setWorkMode(long workMode) {
    this.workMode = workMode;
  }


  public long getExpectSalary() {
    return expectSalary;
  }

  public void setExpectSalary(long expectSalary) {
    this.expectSalary = expectSalary;
  }


  public String getExpectCity() {
    return expectCity;
  }

  public void setExpectCity(String expectCity) {
    this.expectCity = expectCity;
  }

}
