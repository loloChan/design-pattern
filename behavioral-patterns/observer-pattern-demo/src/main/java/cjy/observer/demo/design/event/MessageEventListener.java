package cjy.observer.demo.design.event;

import cjy.observer.demo.design.vo.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 短信通知
 */
public class MessageEventListener implements EventListener {

    private static Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    /**
     * 触发事件
     *
     * @param lotteryResult
     */
    @Override
    public void doEvent(LotteryResult lotteryResult) {
        logger.info("给用户 {} 发送短信通知：{}",lotteryResult.getUid(),lotteryResult.getResult());
    }
}
