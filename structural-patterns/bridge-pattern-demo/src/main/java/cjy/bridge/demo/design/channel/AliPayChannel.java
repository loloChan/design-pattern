package cjy.bridge.demo.design.channel;

import cjy.bridge.demo.design.mode.PayMode;

import java.math.BigDecimal;

/**
 * 支付宝支付
 */
public class AliPayChannel extends PayChannel {
    public AliPayChannel(PayMode payMode) {
        super(payMode);
    }

    /**
     * 支付
     *
     * @param userId
     * @param tradeId
     * @param amount
     * @return
     */
    @Override
    public String transfer(String userId, String tradeId, BigDecimal amount) {
        logger.info("模拟支付宝支付。userid={},tradeId={},amount={}", userId, tradeId, amount);

        logger.info("模拟支付模式风险校验......");
        boolean security = payMode.security();
        if (security) {
            logger.info("支付宝支付成功！");
            return "200";
        }
        logger.info("支付宝支付失败");
        return "400";
    }
}
