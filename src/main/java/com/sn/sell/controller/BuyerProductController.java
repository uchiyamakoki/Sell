package com.sn.sell.controller;

import com.sn.sell.VO.ProductInfoVO;
import com.sn.sell.VO.ProductVO;
import com.sn.sell.VO.ResultVO;
import com.sn.sell.dataobject.ProductInfo;
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

    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO=new ResultVO();

        ProductVO productVO=new ProductVO();
        ProductInfoVO productInfo=new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfo));
        resultVO.setData(Arrays.asList(productVO));


        resultVO.setCode(0);
        resultVO.setMsg("成功");

       /* ProductVO productVO=new ProductVO();
        ProductInfoVO productInfo=new ProductInfoVO();
        List<ProductInfoVO> list=new ArrayList<ProductInfoVO>();
        list.add(productInfo);
        productVO.setProductInfoVOList(list);
        resultVO.setData(productVO);*/

        return resultVO;
    }
}
