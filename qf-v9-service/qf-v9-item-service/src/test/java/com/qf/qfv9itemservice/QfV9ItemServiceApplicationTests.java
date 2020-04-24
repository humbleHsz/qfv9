package com.qf.qfv9itemservice;

import Util.ResultBean;
import com.qf.api.item.ItemService;
import com.qf.qfv9itemservice.service.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class QfV9ItemServiceApplicationTests {




    @Test
    void contextLoads() {

        List<Long> idList=new ArrayList<>(Arrays.asList(1L,2L,3L,4L,8L,9L,10L));
        ResultBean resultBean = new ItemServiceImpl().batchCreateHtml(idList);
        System.out.println(resultBean.getMsg());


    }

}
