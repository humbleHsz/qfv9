package com.qf.jpa.repository;

import com.qf.v9.entity.DO.TProductDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<TProductDO,Long> {


    @Query(value = "select * from t_product ",nativeQuery = true)
    List<TProductDO> listAllProduct();

    @Query(value = "select * from t_product ",countQuery = "select count(*) from t_product ",nativeQuery = true)
    Page<TProductDO> listAllProductToPage(Pageable pageable);
}
