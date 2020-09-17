package cjy.adapter.demo.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POPOrderService {

    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询⽤户的订单是否为⾸单：{}", uId);
        return true;
    }

}
