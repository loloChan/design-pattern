package cjy.adapter.demo.common.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 开户mq消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountMq {

    /**
     * 开户编号
     */
    private String number;

    /**
     * 开户地
     */
    private String address;

    /**
     * 开户时间
     */
    private Date accountDate;

    /**
     * 开户描述
     */
    private String desc;

}
