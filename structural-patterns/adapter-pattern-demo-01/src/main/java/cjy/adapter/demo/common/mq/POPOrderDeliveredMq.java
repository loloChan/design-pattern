package cjy.adapter.demo.common.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 第三方订单Mq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class POPOrderDeliveredMq {

    /**
     * 用户id
     */
    private String uId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 商品编号
     */
    private Date sku;

    /**
     * 商品名称
     */
    private Date skuName;

    /**
     * 金额
     */
    private BigDecimal decimal;

}
