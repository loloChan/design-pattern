package cjy.strategy.demo.design;

import cjy.strategy.demo.design.coupon.ICouponDiscount;

import java.math.BigDecimal;

/**
 * 策略控制类
 */
public class Context<T> {

    /**
     * 优惠券执行器
     */
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public void setCouponDiscount(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 金额结算
     * @param couponInfo
     * @param settlePrice
     * @return
     */
    public BigDecimal discountAmount(T couponInfo, BigDecimal settlePrice) {

        BigDecimal result = couponDiscount.discountAmount(couponInfo, settlePrice);
        return result;

    }

}
