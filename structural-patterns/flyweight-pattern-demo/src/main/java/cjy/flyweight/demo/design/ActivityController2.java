package cjy.flyweight.demo.design;

import cjy.flyweight.demo.design.factory.ActivityFactory;
import cjy.flyweight.demo.design.util.RedisUtils;
import cjy.flyweight.demo.vo.Activity;
import cjy.flyweight.demo.vo.Stock;

public class ActivityController2 {

    private static RedisUtils redisUtils = new RedisUtils();

    /**
     * 根据活动id查找活动信息
     * @param activityId
     * @return
     */
    public Activity queryActivityInfo(Long activityId) {

        //获取共享的活动信息，没有则创建
        Activity activity = ActivityFactory.getActivity(activityId);

        //库存信息是变动的，每次请求都将会更新
        Stock stock = new Stock();
        stock.setTotal(1000);
        stock.setUsed(redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
