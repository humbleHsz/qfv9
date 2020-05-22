package com.qf.jpa.repository;

import com.qf.v9.entity.DO.TUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<TUserDO,Long> {

    @Query(value = "SELECT * from t_user where  status=1 and flag=1 and username=?1 or phone=?1 or email=?1",nativeQuery = true)
    TUserDO findByUserName(String userName);

}
