package com.qf.qfv9itemservice.handler;


import com.qf.api.item.ItemService;
import constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class consumer {


    @Autowired
    private ItemService itemService;

    @RabbitListener(queues = RabbitMQConstant.ITEM_CREATE_HTML_QUEUE)
    public void processCreateHtml(Long id){
        itemService.createHtmlById(id);

    }
}
