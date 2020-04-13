package com.qf.product.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.qf.api.product.IProductService;
import com.qf.jpa.repository.ProductRepository;
import com.qf.v9.entity.TProduct;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service(interfaceClass = IProductService.class,timeout = 15000)
public class ProductService implements IProductService {

    @Resource
   private ProductRepository productRepository;

    @Override
    public List<TProduct> listAllProduct() {
        return productRepository.listAllProduct();
    }
}
