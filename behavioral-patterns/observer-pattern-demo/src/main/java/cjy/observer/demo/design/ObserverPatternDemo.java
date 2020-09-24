package cjy.observer.demo.design;

import cjy.observer.demo.design.service.LotteryService;
import cjy.observer.demo.design.service.LotteryServiceImpl;
import cjy.observer.demo.design.vo.LotteryResult;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverPatternDemo {

    private static Logger logger = LoggerFactory.getLogger(ObserverPatternDemo.class);

    public static void main(String[] args) {

        LotteryService lotteryService = new LotteryServiceImpl();

        LotteryResult result = lotteryService.draw("豆豆");

        logger.info("测试结果：{}", JSON.toJSONString(result));

    }

}
