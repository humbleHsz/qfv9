package com.qf.qfv9search.controller;


import Util.ResultBean;
import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.search.ISearchService;
import com.qf.v9.entity.DO.TProductDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/search")
public class searchController {

    @Reference
    private ISearchService iSearchService;

    @RequestMapping("/initAllData")
    @ResponseBody
    public ResultBean initAllData(){
        return iSearchService.initAllData();
    }


    @GetMapping("/byKey")
    public String searchByKey(Model model){

        List<TProductDO> list = iSearchService.searchByKeyWord("发烧");
        model.addAttribute("list",list);
        return "list";
    }
}
