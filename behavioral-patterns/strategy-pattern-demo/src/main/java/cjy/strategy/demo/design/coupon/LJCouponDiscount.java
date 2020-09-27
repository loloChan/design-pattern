package cjy.strategy.demo.design.coupon;

import cjy.strategy.demo.design.vo.CouponInfo;

import java.math.BigDecimal;

/**
 * 立减优惠券
 */
public class LJCouponDiscount implements ICouponDiscount<CouponInfo> {
    /**
     * 优惠结算
     *
     * @param couponInfo  优惠信息
     * @param settlePrice 未优惠金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(CouponInfo couponInfo, BigDecimal settlePrice) {

        //立减金额
        BigDecimal quota = new BigDecimal(couponInfo.getQuota());

        BigDecimal result = settlePrice.subtract(quota);

        //合法性判断
        if (result.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return result;
    }
}
