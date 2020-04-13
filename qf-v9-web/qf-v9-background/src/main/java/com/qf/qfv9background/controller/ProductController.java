package com.qf.qfv9background.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.product.IProductService;
import com.qf.api.product.IProductTypeService;
import com.qf.v9.entity.TProduct;
import com.qf.v9.entity.TProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {



    @Reference
    private IProductService iProductService;


    @GetMapping("/list")
    public String list(Model model){
        List<TProduct> list = iProductService.listAllProduct();
        model.addAttribute("list",list);
        return "product/list";
    }




}
