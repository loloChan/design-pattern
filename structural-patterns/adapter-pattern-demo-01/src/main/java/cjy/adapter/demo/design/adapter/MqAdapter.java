package cjy.adapter.demo.design.adapter;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * mq消息适配器
 */
public final class MqAdapter {

    /**
     * 将各种结构的消息转换为该系统的统一结构BaseMessage类型
     * @param message mq消息
     * @param link 转换属性之间的对应关系
     * @return
     */
    public static BaseMessage filter(String message, Map<String, String> link) throws Exception{

        BaseMessage baseMessage = new BaseMessage();
        
        Map<String, String> mqMessageMap = JSON.parseObject(message, Map.class);
        
        //将mq属性与系统对应属性适配
        for (String key : mqMessageMap.keySet()) {
            if (!link.containsKey(key)) {
                continue;
            }
            //通过mq的key，获取到该系统适配对应的key
            String adapterKey = link.get(key);
            Object val = mqMessageMap.get(key);
            String methodName = adapterKey.substring(0, 1).toUpperCase() + adapterKey.substring(1);
            Method getter = BaseMessage.class.getMethod("get" + methodName);
            //获取返回值类型
            Class<?> type = getter.getReturnType();
            if (null == type) {
                continue;
            }
            Method setter = BaseMessage.class.getMethod("set" + methodName,type);
            if (null != setter) {
                setter.invoke(baseMessage, val);
            }
        }

        return baseMessage;

    }

}
