package com.qf.jpa.repository;

import com.qf.v9.entity.TProduct;
import com.qf.v9.entity.TProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<TProductType,Long> {

    @Query(value = "select  * from t_product_type",nativeQuery = true)
    List<TProductType> findALl();

    @Query(value = "select * from t_product ",nativeQuery = true)
    List<TProduct> listAllProduct();
}
