package com.qf.qfv9background.controller;

import Util.ResultBean;
import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.item.ItemService;
import com.qf.api.product.IProductService;
import com.qf.api.search.ISearchService;
import com.qf.v9.entity.DO.TProductDO;
import com.qf.v9.entity.DTO.PageInfo;
import com.qf.v9.entity.VO.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {



    @Reference
    private IProductService iProductService;

    @Reference
    private ISearchService iSearchService;

    @Reference
    private ItemService itemService;

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
        Long id = iProductService.add(productVO);

        //让搜索服务同步这个数据
        iSearchService.updateById(id);
        itemService.createHtmlById(id);
        return "redirect:/product/list/1/3";
    }


    /**
     * 测试批量生成service
     */
    @ResponseBody
    @GetMapping("/test")
    public void test(){
        List<Long> idList=new ArrayList<>(Arrays.asList(1L,2L,3L,4L,8L,9L,10L));
        ResultBean resultBean = itemService.batchCreateHtml(idList);
        System.out.println(resultBean.getMsg());
    }

}
