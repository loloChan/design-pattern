package cjy.decorator.demo.design;

import cjy.decorator.demo.undesign.HandlerInterceptor;
import cjy.decorator.demo.undesign.vo.Request;
import cjy.decorator.demo.undesign.vo.Response;

/**
 * 抽象装饰类
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(Request request, Response response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
