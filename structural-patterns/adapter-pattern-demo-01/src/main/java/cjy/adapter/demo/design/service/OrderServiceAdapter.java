package cjy.adapter.demo.design.service;

/**
 * 接口适配
 * 订单服务接口适配器
 */
public interface OrderServiceAdapter {

    /**
     * 根据用户id判断是否首单
     * @param userId
     * @return
     */
    boolean isFirst(String userId);

}
