package com.sn.sell.repository;

import com.sn.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{
    //按照买家的openid查
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
