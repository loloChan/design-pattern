package cjy.adapter.demo.design.service;

import cjy.adapter.demo.common.service.OrderService;

/**
 * 内部订单服务
 */
public class InsideOrderServiceAdapter implements OrderServiceAdapter{

    private OrderService orderService = new OrderService();

    /**
     * 根据用户id判断是否首单
     *
     * @param userId
     * @return
     */
    public boolean isFirst(String userId) {
        return orderService.queryUserOrderCount(userId) < 1;
    }
}
