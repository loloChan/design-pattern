package cjy.decorator.demo.undesign.vo;

import lombok.Data;

/**
 * 模拟HttpRequest
 */
@Data
public class Request {

    private String userId;

    private String cookie;

    private String requestMethod;

}
