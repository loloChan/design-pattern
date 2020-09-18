package cjy.decorator.demo.undesign;

import cjy.decorator.demo.undesign.vo.Request;
import cjy.decorator.demo.undesign.vo.Response;

/**
 * 模拟单点登录功能实现
 */
public class SsoHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(Request request, Response response, Object handler) {

        //模拟获取cookie
        String cookie = request.getCookie();

        //模拟对cookie进行验证
        return validate(cookie);
    }

    /**
     * 对cookie进行验证
     * @param cookie
     * @return
     */
    private boolean validate(String cookie) {
        return true;
    }
}
