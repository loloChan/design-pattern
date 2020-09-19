package cjy.facade.demo.design.aspect;

import cjy.facade.demo.design.annotation.DoDoor;
import cjy.facade.demo.design.config.AuthService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 白名单切面逻辑
 */
@Aspect
@Component
public class DoJoinPoint {

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

    /**
     * 白名单服务
     */
    @Autowired
    private AuthService authService;

    /**
     * 切面
     */
    @Pointcut("@annotation(cjy.facade.demo.design.annotation.DoDoor)")
    public void aopPoint() {

    }

    /**
     * 切面核心逻辑，用于判断用户是否在白名单中
     * @param joinPoint
     * @return
     * @throws Exception
     */
    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取拦截的方法
        Method method = getMethod(joinPoint);
        DoDoor doDoor = method.getAnnotation(DoDoor.class);

        //获取验证字段的值
        String fieldValue = getFieldValue(doDoor.key(), joinPoint.getArgs());

        logger.info("dodoor handler method {},value {}", method.getName(), fieldValue);

        if ("".equals(fieldValue) || null == fieldValue) {
            return joinPoint.proceed();
        }

        boolean isWhite = authService.isWhiteList(fieldValue);

        if (isWhite) {
            return joinPoint.proceed();
        }

        return returnObj(doDoor, method);

    }

    /**
     * 获取method
     * @param joinPoint
     * @return
     * @throws NoSuchMethodException
     */
    private Method getMethod(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            return null;
        }
        MethodSignature methodSignature = (MethodSignature) signature;

        Method method = getClass(joinPoint).getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        return method;

    }

    /**
     * 获取class
     * @param joinPoint
     * @return
     */
    private Class<?> getClass(ProceedingJoinPoint joinPoint) {
        return joinPoint.getTarget().getClass();
    }

    /**
     * 拦截后返回对象
     * @param doDoor
     * @param method
     * @return
     */
    private Object returnObj(DoDoor doDoor, Method method) throws Exception {

        //原方法返回类型
        Class<?> type = method.getReturnType();
        //设置的拦截返回值
        String returnJson = doDoor.returnJson();
        if ("".equals(returnJson)) {
            return type.newInstance();
        }
        return JSON.parseObject(returnJson, type);

    }

    /**
     * 根据DoDoor配置的key获取入参对应参数的值
     * @param fieldName
     * @param args
     * @return
     */
    private String getFieldValue(String fieldName, Object[] args) {

        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || "".equals(filedValue)) {
                    filedValue = BeanUtils.getProperty(arg, fieldName);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;

    }

}
