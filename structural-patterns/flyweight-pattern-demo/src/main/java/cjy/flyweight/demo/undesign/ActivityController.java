package cjy.flyweight.demo.undesign;

import cjy.flyweight.demo.vo.Activity;
import cjy.flyweight.demo.vo.Stock;

import java.util.Date;

/**
 * 活动控制器
 */
public class ActivityController {

    /**
     * 根据活动id查找活动信息
     * @param activityId
     * @return
     */
    public Activity queryActivityInfo(Long activityId) {

        //模拟根据id从数据库获取数据
        Activity activity = new Activity();
        activity.setId(activityId);
        activity.setName("手机0元购");
        activity.setDesc("手机0首付免息分期购买活动");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        Stock stock = new Stock();
        stock.setTotal(1000);
        stock.setUsed(5);
        activity.setStock(stock);
        return activity;
    }

}
