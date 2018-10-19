package com.sn.sell.controller;

import com.sn.sell.VO.ProductInfoVO;
import com.sn.sell.VO.ProductVO;
import com.sn.sell.VO.ResultVO;
import com.sn.sell.dataobject.ProductCategory;
import com.sn.sell.dataobject.ProductInfo;
import com.sn.sell.service.CategoryService;
import com.sn.sell.service.ProductService;
import com.sn.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.先查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        //2.查询蕾姆(一次性查询)
        List<Integer> categoryTypeList=new ArrayList<Integer>();
        for(ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //精简方法（java8,lambda）
       // productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList=new ArrayList<ProductVO>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVoList=new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                          ProductInfoVO productInfoVO=new ProductInfoVO();
                         BeanUtils.copyProperties(productInfo,productInfoVO);
                         productInfoVoList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVoList);
            productVOList.add(productVO);
        }
        ResultVO resultVO=new ResultVO();

        //ProductVO productVO=new ProductVO();
        //ProductInfoVO productInfo=new ProductInfoVO();
        //productVO.setProductInfoVOList(Arrays.asList(productInfo));
       //resultVO.setData(Arrays.asList(productVO));
        //resultVO.setData(productVOList);

        //resultVO.setCode(0);
        //resultVO.setMsg("成功");

       /* ProductVO productVO=new ProductVO();
        ProductInfoVO productInfo=new ProductInfoVO();
        List<ProductInfoVO> list=new ArrayList<ProductInfoVO>();
        list.add(productInfo);
        productVO.setProductInfoVOList(list);
        resultVO.setData(productVO);*/
        return  ResultVOUtil.success(productVOList);
    }
}
