package com.qf.qfv9background.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.product.IProductService;
import com.qf.v9.entity.DO.TProductDO;
import com.qf.v9.entity.DTO.PageInfo;
import com.qf.v9.entity.VO.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {



    @Reference
    private IProductService iProductService;


    @GetMapping("/list")
    public String list(Model model){
        List<TProductDO> list = iProductService.listAllProduct();
        model.addAttribute("list",list);
        return "product/list";
    }

    @GetMapping("/list/{pageIndex}/{pageSize}")
    public String listToPage(Model model, @PathVariable(value = "pageIndex") Integer pageIndex,@PathVariable(value = "pageSize") Integer pageSize){
        PageInfo pageInfo = iProductService.listAllProductToPage(pageIndex, pageSize);
        model.addAttribute("page",pageInfo);
        return "product/list";
    }

    @PostMapping("/add")
    public String add(ProductVO productVO){
        Long add = iProductService.add(productVO);
        return "redirect:/product/list/1/3";
    }

}
