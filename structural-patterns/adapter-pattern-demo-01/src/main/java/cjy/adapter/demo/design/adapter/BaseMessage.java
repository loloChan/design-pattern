package cjy.adapter.demo.design.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 统一的消息结构,属性适配
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseMessage {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务时间
     */
    private Date bizTime;

    /**
     * 业务描述
     */
    private String desc;

}
