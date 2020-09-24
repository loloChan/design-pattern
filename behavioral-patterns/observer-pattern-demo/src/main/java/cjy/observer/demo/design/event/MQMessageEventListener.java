package cjy.observer.demo.design.event;

import cjy.observer.demo.design.vo.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MQ消息
 */
public class MQMessageEventListener implements EventListener {

    private static Logger logger = LoggerFactory.getLogger(MQMessageEventListener.class);

    /**
     * 触发事件
     *
     * @param lotteryResult
     */
    @Override
    public void doEvent(LotteryResult lotteryResult) {
        logger.info("MQ:记录用户 {} 摇号结果：{}",lotteryResult.getUid(),lotteryResult.getResult());
    }
}
