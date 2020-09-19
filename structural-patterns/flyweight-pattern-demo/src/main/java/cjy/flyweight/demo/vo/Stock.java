package cjy.flyweight.demo.vo;

import lombok.Data;

/**
 * 库存信息
 */
@Data
public class Stock {

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 库存总量
     */
    private Integer total;

    /**
     * 已使用数量
     */
    private Integer used;

}
