package com.qf.v9.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_product_desc")
@Entity
public class TProductDesc implements Serializable {

  @Id
  private Integer id;
  private String pDesc;
  private Integer productId;

}
