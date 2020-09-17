package cjy.adapter.demo.undesign.service;

import cjy.adapter.demo.common.mq.OrderMq;
import com.alibaba.fastjson.JSON;

/**
 * 处理OrderMq消息
 */
public class OrderMqService {

    /**
     * 消息处理
     * @param message ma消息
     */
    public void processMessage(String message) {

        OrderMq orderMq = JSON.parseObject(message, OrderMq.class);

        //TODO 业务处理

    }

}
