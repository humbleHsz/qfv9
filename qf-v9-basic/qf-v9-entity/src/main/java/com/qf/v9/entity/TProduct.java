package com.qf.v9.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_product")
@Entity
public class TProduct implements Serializable {

  @Id
  private Long id;
  private String name;
  private Long price;
  private Long salePrice;
  private String salePoint;
  private String image;
  private Long stock;
  private Integer flag;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private Long createUser;
  private Long updateUser;
  private Long typeId;
  private String typeName;



}
