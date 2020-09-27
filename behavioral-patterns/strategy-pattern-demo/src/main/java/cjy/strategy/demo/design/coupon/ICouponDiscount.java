package cjy.strategy.demo.design.coupon;

import java.math.BigDecimal;

/**
 * 优惠券接口
 */
public interface ICouponDiscount<T> {

    /**
     * 优惠结算
     * @param couponInfo 优惠信息
     * @param settlePrice 未优惠金额
     * @return
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal settlePrice);

}
