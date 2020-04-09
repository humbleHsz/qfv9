package com.qf.qfv9background.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.product.IProductTypeService;
import com.qf.v9.entity.TProductType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 商品的分类信息
 */
@RestController
@RequestMapping("/productType")
public class ProductTypeController {

   @Reference
    private IProductTypeService productTypeService;

    @GetMapping("/list")
    public List<TProductType> list(){
        return productTypeService.list();
    }
}
