package cjy.observer.demo.design.event;

import cjy.observer.demo.design.vo.LotteryResult;

/**
 * 事件监听接口
 */
public interface EventListener {

    /**
     * 触发事件
     * @param lotteryResult
     */
    void doEvent(LotteryResult lotteryResult);

}
