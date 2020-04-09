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
  private Integer id;
  private String name;
  private Integer price;
  private Integer salePrice;
  private String salePoint;
  private String image;
  private Integer stock;
  private Integer flag;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private Integer createUser;
  private Integer updateUser;
  private Integer typeId;
  private String typeName;



}
