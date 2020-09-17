package cjy.adapter.demo.undesign.service;

import cjy.adapter.demo.common.mq.CreateAccountMq;
import com.alibaba.fastjson.JSON;

/**
 * 处理createAccountMq消息
 */
public class CreateAccountMqService {

    /**
     * 消息处理
     * @param message mq消息
     */
    public void processMessage(String message) {

        CreateAccountMq createAccountMq = JSON.parseObject(message, CreateAccountMq.class);

        String number = createAccountMq.getNumber();
        String desc = createAccountMq.getDesc();
        //...

        //TODO 业务处理

    }

}
