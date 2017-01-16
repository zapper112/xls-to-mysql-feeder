package com.zapper.dbFeed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Satyarth on 12/1/17.
 */
@Entity
@Table(name = "institutionCode")
public class InstitutionCode {

  private Integer id;
  private String instiType;
  private Integer instiCode;

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "instiType")
  public String getInstiType() {
    return instiType;
  }

  public void setInstiType(String instiType) {
    this.instiType = instiType;
  }

  @Column(name = "instiCode")
  public Integer getInstiCode() {
    return instiCode;
  }

  public void setInstiCode(Integer instiCode) {
    this.instiCode = instiCode;
  }
}
