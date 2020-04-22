package com.qf.qfv9index.controller;


import com.qf.api.product.IProductTypeService;
import com.qf.qfv9index.pojo.Node;
import com.qf.qfv9index.service.NodeTree;
import com.qf.v9.entity.DO.TProductTypeDO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/index")
public class IndexController {

    @Reference
    private IProductTypeService iproductTypeService;

    @ResponseBody
    @GetMapping("/listType")
    public List<Node> listType(){
        List<TProductTypeDO> list = iproductTypeService.list();
        return new NodeTree(list).getTree();
    }

}
