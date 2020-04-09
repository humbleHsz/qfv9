package com.qf.product.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.qf.api.product.IProductTypeService;
import com.qf.jpa.repository.ProductTypeRepository;
import com.qf.v9.entity.TProductType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service(interfaceClass = IProductTypeService.class,timeout = 15000)
public class ProductTypeService implements IProductTypeService {

    @Resource
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<TProductType> list(){
        return productTypeRepository.findALl();
    }

}
