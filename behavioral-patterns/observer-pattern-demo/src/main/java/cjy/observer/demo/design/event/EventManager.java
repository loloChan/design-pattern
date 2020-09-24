package cjy.observer.demo.design.event;

import cjy.observer.demo.design.vo.LotteryResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件管理器
 */
public final class EventManager {

    /**
     * 监听器
     */
    private static Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    static {
        //初始化监听器集合
        for (EventType value : EventType.values()) {
            listeners.put(value, new ArrayList<>());
        }
    }

    /**
     * 订阅监听事件
     * @param eventType 事件类型
     * @param listener 监听器
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.add(listener);
    }

    /**
     * 取消订阅
     * @param eventType
     * @param listener
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.remove(listener);
    }

    /**
     * 通知
     * @param eventType 事件类型
     * @param lotteryResult 结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult lotteryResult) {
        List<EventListener> eventListeners = listeners.get(eventType);
        for (EventListener eventListener : eventListeners) {
            eventListener.doEvent(lotteryResult);
        }
    }

}
