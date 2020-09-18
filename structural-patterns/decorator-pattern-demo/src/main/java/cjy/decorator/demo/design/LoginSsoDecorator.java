package cjy.decorator.demo.design;

import cjy.decorator.demo.undesign.HandlerInterceptor;
import cjy.decorator.demo.undesign.vo.Request;
import cjy.decorator.demo.undesign.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 具体装饰类的实现
 */
public class LoginSsoDecorator extends SsoDecorator {

    private static Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("xiaoming", "query");
        authMap.put("zhangsan", "insert");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(Request request, Response response, Object handler) {
        //原来验证部分
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }

        //增强部分
        String userId = request.getUserId();
        String requestMethod = request.getRequestMethod();
        logger.info("模拟单点登录方法拦截校验:{},{}", userId, requestMethod);

        return requestMethod.contains(authMap.get(userId));
    }
}
