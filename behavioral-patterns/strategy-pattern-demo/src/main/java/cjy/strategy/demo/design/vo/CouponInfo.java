package cjy.strategy.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponInfo {

    /**
     * 优惠金额/折扣
     */
    private Double quota;

    /**
     * 基础金额
     */
    private Double base;

}
