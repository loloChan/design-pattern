package cjy.observer.demo.design.service;

import cjy.observer.demo.design.event.EventManager;
import cjy.observer.demo.design.event.EventType;
import cjy.observer.demo.design.event.MQMessageEventListener;
import cjy.observer.demo.design.event.MessageEventListener;
import cjy.observer.demo.design.vo.LotteryResult;

/**
 * 抽象摇号服务类
 */
public abstract class LotteryService {

    /**
     * 事件管理器
     */
    private EventManager eventManager;

    public LotteryService() {

        //注册事件监听器
        eventManager = new EventManager();
        eventManager.subscribe(EventType.MQ, new MQMessageEventListener());
        eventManager.subscribe(EventType.Message, new MessageEventListener());
    }

    /**
     * 摇号
     * @param uid
     * @return
     */
    public LotteryResult draw(String uid) {

        LotteryResult lotteryResult = doDraw(uid);
        eventManager.notify(EventType.Message, lotteryResult);
        eventManager.notify(EventType.MQ, lotteryResult);

        return lotteryResult;

    }

    /**
     * 摇号的具体实现
     * @param uid
     * @return
     */
    protected abstract LotteryResult doDraw(String uid);

}
