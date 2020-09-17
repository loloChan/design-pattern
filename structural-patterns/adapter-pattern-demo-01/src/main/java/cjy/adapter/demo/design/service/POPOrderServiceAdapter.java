package cjy.adapter.demo.design.service;

import cjy.adapter.demo.common.service.POPOrderService;

/**
 * 第三方订单服务
 */
public class POPOrderServiceAdapter implements OrderServiceAdapter {

    private POPOrderService popOrderService = new POPOrderService();

    /**
     * 根据用户id判断是否首单
     *
     * @param userId
     * @return
     */
    public boolean isFirst(String userId) {
        return popOrderService.isFirstOrder(userId);
    }
}
