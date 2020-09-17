package cjy.adapter.demo.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId){
        logger.info("⾃营商家，查询⽤户的订单是否为⾸单：{}", userId);
        return 10L;
    }

}
