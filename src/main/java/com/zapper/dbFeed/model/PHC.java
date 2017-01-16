package com.zapper.dbFeed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Satyarth on 11/1/17.
 */
@Entity
@Table(name = "PHC")
public class PHC {

  private Integer id;
  private Integer code;
  private String district;
  private Integer institutionCode;
  private String institutionType;
  private String hospitalSerialNo;
  private String name;
  private Integer UHC;

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "code")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  @Column(name = "district")
  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  @Column(name = "institutionCode")
  public Integer getInstitutionCode() {
    return institutionCode;
  }

  public void setInstitutionCode(Integer institutionCode) {
    this.institutionCode = institutionCode;
  }

  @Column(name = "institutionType")
  public String getInstitutionType() {
    return institutionType;
  }

  public void setInstitutionType(String institutionType) {
    this.institutionType = institutionType;
  }

  @Column(name = "hospitalSerialNo")
  public String getHospitalSerialNo() {
    return hospitalSerialNo;
  }

  public void setHospitalSerialNo(String hospitalSerialNo) {
    this.hospitalSerialNo = hospitalSerialNo;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "UHC")
  public Integer getUHC() {
    return UHC;
  }

  public void setUHC(Integer UHC) {
    this.UHC = UHC;
  }
}
