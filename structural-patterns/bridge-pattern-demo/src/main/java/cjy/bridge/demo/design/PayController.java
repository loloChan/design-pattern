package cjy.bridge.demo.design;

import cjy.bridge.demo.design.channel.AliPayChannel;
import cjy.bridge.demo.design.channel.PayChannel;
import cjy.bridge.demo.design.mode.CypherPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PayController {

    private static Logger logger = LoggerFactory.getLogger(PayController.class);
    /**
     * 支付测试
     * @param userId 用户id
     * @param tradeId 交易id
     * @param amount 金额
     * @return
     */
    public boolean pay(String userId, String tradeId, BigDecimal amount) {

        logger.info("模拟支付开始，userid={},tradeId={},amount={}", userId, tradeId, amount);

        //这里可以继续结合策略、工厂等模式进一步设计
        PayChannel payChannel = new AliPayChannel(new CypherPayMode());

        String transfer = payChannel.transfer(userId, tradeId, amount);

        if (!"200".equals(transfer)) {
            logger.info("交易失败！");
            return false;
        }
        logger.info("交易成功！");
        return true;
    }

}
