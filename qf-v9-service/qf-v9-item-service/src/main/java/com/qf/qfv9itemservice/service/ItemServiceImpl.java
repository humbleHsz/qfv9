package com.qf.qfv9itemservice.service;

import Util.ResultBean;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.api.item.ItemService;
import com.qf.jpa.repository.ProductRepository;
import com.qf.v9.entity.DO.TProductDO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;


@Component
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ProductRepository productRepository;

    @Autowired
    private Configuration configuration;

    //拿到cpu的核心数量
    private int corePoolSize=Runtime.getRuntime().availableProcessors();

    private ExecutorService pool= new ThreadPoolExecutor(corePoolSize,corePoolSize*2,
                    0L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100));

    @Override
    public ResultBean createHtmlById(Long productId) {

        try {
            Template template = configuration.getTemplate("item.html");

            Optional<TProductDO> optional = productRepository.findById(productId);
            TProductDO product = optional.get();

            Map<String,Object> data=new HashMap<>();

            data.put("product",product);

            FileWriter fileWriter=new FileWriter("/Users/gh_23/Desktop/qfv9/qf-v9-service/qf-v9-item-service/src/main/resources/templates/item.ftl");

            template.process(data,fileWriter);

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return ResultBean.error("生成静态页面错误！");
        }

        return ResultBean.success("生成静态页面成功！");
    }



    @Override
    public ResultBean batchCreateHtml(List<Long> idList) {

        List<Future<Boolean>> futureList=new ArrayList<>(idList.size());

        for (Long id : idList) {
            futureList.add(pool.submit(new createHtmlTask(id)));
        }
        for (Future<Boolean> booleanFuture : futureList) {
            try {
                System.out.println(booleanFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return ResultBean.success("批量生成页面成功！");
    }

    private class createHtmlTask implements Callable<Boolean> {

        private Long productId;

        private createHtmlTask(Long id){
           this.productId=id;
        }
        @Override
        public Boolean call() throws Exception {

            try {
                Template template = configuration.getTemplate("item.html");

                Optional<TProductDO> optional = productRepository.findById(productId);
                TProductDO product = optional.get();

                Map<String,Object> data=new HashMap<>();

                data.put("product",product);

                FileWriter fileWriter=new FileWriter("/Users/gh_23/Desktop/qfv9/qf-v9-service/qf-v9-item-service/src/main/resources/templates/"+productId+".ftl");

                template.process(data,fileWriter);

            } catch (IOException | TemplateException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}



