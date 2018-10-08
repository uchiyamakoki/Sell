package com.sn.sell.repository;

import com.sn.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory=repository.findOne(2);
        productCategory.setCategoryType(10);
        //ProductCategory productCategory=new ProductCategory();
      //  productCategory.setCategoryId(2);
       // productCategory.setCategoryName("男生最爱");
        //productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

}