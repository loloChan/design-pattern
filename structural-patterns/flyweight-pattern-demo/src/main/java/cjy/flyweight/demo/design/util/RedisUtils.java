package cjy.flyweight.demo.design.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟从Redis中获取库存数据
 */
public class RedisUtils {

    private static AtomicInteger count = new AtomicInteger(0);

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


    public RedisUtils() {

        scheduledExecutorService.scheduleAtFixedRate(() -> {

            //模拟库存消耗
            count.addAndGet(1);

        }, 0,10000, TimeUnit.MICROSECONDS);
    }

    /**
     * 模拟从redis中获取已使用数量
     * @return
     */
    public int getStockUsed() {
        return count.get();
    }

}
