package com.qf.v9.entity.DO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
@Entity
public class TUserDO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String phone;
  private String email;
  private String password;
  private String username;
  private Integer status;
  private Integer flag;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private Integer createUser;
  private Integer updateUser;


}
