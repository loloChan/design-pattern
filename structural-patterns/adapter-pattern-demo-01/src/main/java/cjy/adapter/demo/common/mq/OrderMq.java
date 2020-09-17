package cjy.adapter.demo.common.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 内部订单MQ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMq {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 商品编号
     */
    private String sku;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 下单时间
     */
    private Date createOrderTime;

}
