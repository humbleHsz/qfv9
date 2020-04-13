package com.qf.v9.entity.DO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_product")
@Entity
public class TProductDO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Long price;
  private Long salePrice;
  private String salePoint;
  private String image;
  private Long stock;
  private Integer flag;
  private String createTime;
  private String updateTime;
  private Long createUser;
  private Long updateUser;
  private Long typeId;
  private String typeName;



}
