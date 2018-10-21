package com.sn.sell.service.impl;

import com.sn.sell.dataobject.OrderDetail;
import com.sn.sell.dataobject.ProductInfo;
import com.sn.sell.dto.OrderDTO;
import com.sn.sell.service.OrderService;
import com.sn.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductService productService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //1.查询商品(数量，价格)
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
            if (productInfo==null){
                //throw new
            }
        }

        //2.计算总价

        //3.写入订单数据库(orderMaster和orderDetail)

        //4.扣库存



        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
