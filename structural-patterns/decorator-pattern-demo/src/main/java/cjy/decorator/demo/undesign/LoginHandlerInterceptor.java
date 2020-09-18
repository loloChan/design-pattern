package cjy.decorator.demo.undesign;

import cjy.decorator.demo.undesign.vo.Request;
import cjy.decorator.demo.undesign.vo.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 直接通过继承，重写方法实现方法增强
 */
public class LoginHandlerInterceptor extends SsoHandlerInterceptor {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("xiaoming", "query");
        authMap.put("zhangsan", "insert");
    }

    @Override
    public boolean preHandle(Request request, Response response, Object handler) {
        //账户校验
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }

        //权限校验
        String userId = request.getUserId();
        String requestMethod = request.getRequestMethod();

        //可访问方法校验
        return requestMethod.contains(authMap.get(userId));
    }
}
