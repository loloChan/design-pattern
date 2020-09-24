package cjy.memento.demo.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class BeanUtils {

    private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * 将bean的成员变量转换为map形式
     * @param bean
     * @return
     */
    public static Map<String, Object> backupProp(Object bean) {

        Map<String, Object> result = new HashMap<>();
        try {
            //获得bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获取property描述
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                //获取成员变量名称
                String name = propertyDescriptor.getName();
                //获取属性的方法
                Method getter = propertyDescriptor.getReadMethod();
                if (null != getter) {
                    //获取属性值
                    Object value = getter.invoke(bean,new Object[]{});

                    result.put(name, value);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    /**
     * 恢复对象状态
     * @param bean 被恢复状态的对象
     * @param stateMap 状态信息
     */
    public static void restoreProp(Object bean, Map<String, Object> stateMap) {
        try {

            //获取Bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获取property描述
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                //获取property name
                String name = propertyDescriptor.getName();
                //判断原状态该属性名是否有值
                if (stateMap.containsKey(name)) {
                    //获取其写方法
                    Method writer = propertyDescriptor.getWriteMethod();
                    if (null != writer) {
                        writer.invoke(bean, stateMap.get(name));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

}
