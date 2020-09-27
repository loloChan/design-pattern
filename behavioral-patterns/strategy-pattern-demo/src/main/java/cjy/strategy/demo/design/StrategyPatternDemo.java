package cjy.strategy.demo.design;


import cjy.strategy.demo.design.coupon.LJCouponDiscount;
import cjy.strategy.demo.design.coupon.MJCouponDiscount;
import cjy.strategy.demo.design.coupon.ZKCouponDiscount;
import cjy.strategy.demo.design.vo.CouponInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class StrategyPatternDemo {

    private static Logger logger = LoggerFactory.getLogger(StrategyPatternDemo.class);

    public static void main(String[] args) {

        BigDecimal result = null;
        Context<CouponInfo> context = new Context<>(new LJCouponDiscount());
        BigDecimal settlePrice = new BigDecimal(500);
        CouponInfo liJianCouponInfo = new CouponInfo(50d, 0d);

        result = context.discountAmount(liJianCouponInfo, settlePrice);
        logger.info("lijian coupon execute : {} -> {} , quota = {}",
                settlePrice, result,liJianCouponInfo.getQuota());

        CouponInfo zheKouCouponInfo = new CouponInfo(0.85, 0d);
        context.setCouponDiscount(new ZKCouponDiscount());
        result = context.discountAmount(zheKouCouponInfo, settlePrice);
        logger.info("zhekou coupon execute : {} -> {} , quota = {}",
                settlePrice, result,zheKouCouponInfo.getQuota());

        CouponInfo manJianCouponInfo = new CouponInfo(60d, 300d);
        context.setCouponDiscount(new MJCouponDiscount());
        result = context.discountAmount(manJianCouponInfo, settlePrice);
        logger.info("manjian coupon execute : {} -> {} , quota = {}",
                settlePrice, result,manJianCouponInfo.getQuota());
    }

}
