package cjy.adapter.demo.undesign.service;

import cjy.adapter.demo.common.mq.POPOrderDeliveredMq;
import com.alibaba.fastjson.JSON;

/**
 * 处理POPOrderDeliveredMq消息
 */
public class POPOrderDeliveredMqService {

    /**
     * 消息处理
     * @param message mq消息
     */
    public void processMessage(String message) {

        POPOrderDeliveredMq popOrderDeliveredMq = JSON.parseObject(message, POPOrderDeliveredMq.class);

        //TODO 业务处理

    }

}
