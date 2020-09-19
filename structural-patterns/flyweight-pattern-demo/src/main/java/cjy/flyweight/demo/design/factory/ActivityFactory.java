package cjy.flyweight.demo.design.factory;

import cjy.flyweight.demo.design.util.RedisUtils;
import cjy.flyweight.demo.vo.Activity;
import cjy.flyweight.demo.vo.Stock;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元工厂，用于管理享元对象
 */
public class ActivityFactory {

    private static Map<Long, Activity> activityMap = new ConcurrentHashMap<>();

    /**
     * 根据id获取Activity
     * @param id
     * @return
     */
    public static Activity getActivity(Long id) {

        Activity activity = activityMap.get(id);
        if (null != activity) {
            return activity;
        }
        activity = new Activity();
        activity.setId(id);
        activity.setName("手机0元购");
        activity.setDesc("手机0首付免息分期购买活动");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());

        activity = activityMap.putIfAbsent(id, activity);
        return activity;
    }

}
