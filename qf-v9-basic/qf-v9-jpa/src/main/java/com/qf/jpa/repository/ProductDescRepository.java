package com.qf.jpa.repository;

import com.qf.v9.entity.DO.TProductDescDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescRepository extends JpaRepository<TProductDescDO,Long> {

}
