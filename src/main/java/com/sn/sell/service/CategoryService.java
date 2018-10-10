package com.sn.sell.service;

import com.sn.sell.dataobject.ProductCategory;

import java.util.List;

/*
蕾姆Service
 */
public interface CategoryService {
    /*
    后台用
     */
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    /*
    买家端用
    通过type来查 list是可以查多个Type 不懂看测试
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
