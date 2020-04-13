package com.qf.api.product;

import com.qf.v9.entity.DO.TProductDO;
import com.qf.v9.entity.DTO.PageInfo;
import com.qf.v9.entity.VO.ProductVO;


import java.util.List;

public interface IProductService {

    List<TProductDO> listAllProduct();

    PageInfo listAllProductToPage(Integer pageIndex, Integer pageSize);

    Long add(ProductVO productVO);
}
