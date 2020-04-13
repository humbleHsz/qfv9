package com.qf.jpa.repository;

import com.qf.v9.entity.DO.TProductTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<TProductTypeDO,Long> {

    @Query(value = "select  * from t_product_type",nativeQuery = true)
    List<TProductTypeDO> findALl();

}
