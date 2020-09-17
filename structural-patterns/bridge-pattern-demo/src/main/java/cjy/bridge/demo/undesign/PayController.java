package cjy.bridge.demo.undesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PayController {

    private static Logger logger = LoggerFactory.getLogger(PayController.class);

    /**
     * 支付
     * @param userId 用户id
     * @param tradeId 交易编号
     * @param amount 金额
     * @param channelType 支付渠道
     * @param modeType 支付模式
     * @return
     */
    public boolean pay(String userId, String tradeId, BigDecimal amount, int channelType, int modeType) {

        if (1 == channelType) {
            //使用微信支付
            logger.info("微信渠道支付开始......userId={},tradeId={},amount={}",userId,tradeId,amount);
            if (1 == modeType) {
                logger.info("密码支付！");
            } else if (2 == modeType) {
                logger.info("指纹支付！");
            } else if (3 == modeType) {
                logger.info("刷脸支付！");
            }

        } else if (2 == channelType) {
            //使用支付宝支付
            logger.info("支付宝渠道支付开始......userId={},tradeId={},amount={}",userId,tradeId,amount);
            if (1 == modeType) {
                logger.info("密码支付！");
            } else if (2 == modeType) {
                logger.info("指纹支付！");
            } else if (3 == modeType) {
                logger.info("刷脸支付！");
            }

        } else {
            return false;
        }

        return true;
    }

}
