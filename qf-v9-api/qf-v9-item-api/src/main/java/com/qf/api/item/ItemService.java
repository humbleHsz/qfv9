package com.qf.api.item;


import Util.ResultBean;

import java.util.List;

public interface ItemService {

    ResultBean createHtmlById(Long productId);

    ResultBean batchCreateHtml(List<Long> idList);
}
