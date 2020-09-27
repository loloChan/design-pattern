package cjy.strategy.demo.design.coupon;

import cjy.strategy.demo.design.vo.CouponInfo;

import java.math.BigDecimal;

/**
 * 折扣优惠券
 */
public class ZKCouponDiscount implements ICouponDiscount<CouponInfo> {
    /**
     * 优惠结算
     *
     * @param couponInfo  优惠信息
     * @param settlePrice 未优惠金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(CouponInfo couponInfo, BigDecimal settlePrice) {

        //折扣力度
        BigDecimal quota = new BigDecimal(couponInfo.getQuota());

        BigDecimal result = settlePrice.multiply(quota);

        if (result.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return result;
    }
}
