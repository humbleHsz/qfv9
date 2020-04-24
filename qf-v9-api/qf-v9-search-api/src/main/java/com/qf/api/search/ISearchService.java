package com.qf.api.search;

import Util.ResultBean;
import com.qf.v9.entity.DO.TProductDO;

import java.util.List;

public interface ISearchService {

   ResultBean initAllData();

   List<TProductDO> searchByKeyWord(String keyWord);

   ResultBean updateById(Long id);

}
