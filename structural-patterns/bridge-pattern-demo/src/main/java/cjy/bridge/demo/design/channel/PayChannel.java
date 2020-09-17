package cjy.bridge.demo.design.channel;

import cjy.bridge.demo.design.mode.PayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 支付渠道
 */
public abstract class PayChannel {

    protected static Logger logger = LoggerFactory.getLogger(PayChannel.class);

    /**
     * 支付方式
     */
    protected PayMode payMode;

    public PayChannel(PayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 支付
     * @param userId
     * @param tradeId
     * @param amount
     * @return
     */
    public abstract String transfer(String userId, String tradeId, BigDecimal amount);

}
