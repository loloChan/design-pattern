package cjy.strategy.demo.design.coupon;

import cjy.strategy.demo.design.vo.CouponInfo;

import java.math.BigDecimal;

/**
 * 满减优惠
 */
public class MJCouponDiscount implements ICouponDiscount<CouponInfo> {
    /**
     * 优惠结算
     *
     * @param couponInfo  优惠信息
     * @param settlePrice 未优惠金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(CouponInfo couponInfo, BigDecimal settlePrice) {

        BigDecimal base = new BigDecimal(couponInfo.getBase());
        BigDecimal quota = new BigDecimal(couponInfo.getQuota());

        //未达到满减条件
        if (settlePrice.compareTo(base) < 0) {
            return settlePrice;
        }

        //达到满减条件
        BigDecimal result = settlePrice.subtract(quota);
        if (result.compareTo(BigDecimal.ZERO) < 1) {
            //减去优惠后金额小于等于0
            return BigDecimal.ONE;
        }
        return result;
    }
}
