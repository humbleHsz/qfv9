package com.qf.v9.entity.DO;


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
public class TProductDescDO implements Serializable {

  @Id
  private Long id;
  private String pDesc;
  private Long productId;

}
