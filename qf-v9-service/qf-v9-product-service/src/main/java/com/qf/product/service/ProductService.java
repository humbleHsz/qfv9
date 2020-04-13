package com.qf.product.service;


import Util.DateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.api.product.IProductService;
import com.qf.jpa.repository.ProductRepository;
import com.qf.v9.entity.DO.TProductDO;
import com.qf.v9.entity.DTO.PageInfo;
import com.qf.v9.entity.VO.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Service(interfaceClass = IProductService.class,timeout = 15000)
public class ProductService implements IProductService {

    @Resource
   private ProductRepository productRepository;

    @Override
    public List<TProductDO> listAllProduct() {
        return productRepository.listAllProduct();
    }

    @Override
    public PageInfo listAllProductToPage(Integer pageIndex, Integer pageSize) {

        Page<TProductDO> page = productRepository.listAllProductToPage(PageRequest.of(pageIndex - 1, pageSize));
        PageInfo pageInfo=new PageInfo();
        pageInfo.setHasPre(page.hasPrevious());
        pageInfo.setHasNext(page.hasNext());
        pageInfo.setSize((int) page.getTotalElements());
        pageInfo.setIndex(pageIndex);
        pageInfo.setTotalPages(page.getTotalPages());
        pageInfo.setList(page.getContent());
        return pageInfo;
    }

    @Override
    public Long add(ProductVO productVO) {
        TProductDO productDO=new TProductDO();
        BeanUtils.copyProperties(productVO.getProduct(),productDO);
        productDO.setCreateTime(DateUtils.getCurrentTime());
        productDO.setUpdateTime(DateUtils.getCurrentTime());
        productDO.setCreateUser(1L);
        productDO.setStock(500L);
        productDO.setFlag(1);
        productDO.setUpdateUser(1L);

        TProductDO save = productRepository.save(productDO);
        return save.getId();
    }


}
