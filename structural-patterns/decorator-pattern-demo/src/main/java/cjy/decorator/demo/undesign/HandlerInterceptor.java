package cjy.decorator.demo.undesign;

import cjy.decorator.demo.undesign.vo.Request;
import cjy.decorator.demo.undesign.vo.Response;

/**
 * 模拟Spring中的HandlerInterceptor类
 */
public interface HandlerInterceptor {

    boolean preHandle(Request request, Response response, Object handler);

}
