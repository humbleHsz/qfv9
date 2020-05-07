package com.qf.qfv9searchservice.handler;


import com.qf.api.search.ISearchService;
import constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {


    @Autowired
    private ISearchService iSearchService;

    @RabbitListener(queues = RabbitMQConstant.BACKGROUND_PRODUCT_UPDATE_QUEUE)
    public void processAddOrUpdate(Long productId) {
        iSearchService.updateById(productId);
    }
}
