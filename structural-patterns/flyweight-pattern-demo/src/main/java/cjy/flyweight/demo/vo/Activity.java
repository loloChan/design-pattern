package cjy.flyweight.demo.vo;

import lombok.Data;

import java.util.Date;

/**
 * 活动信息
 */
@Data
public class Activity {

    /**
     * 活动信息id
     */
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动描述
     */
    private String desc;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date stopTime;

    /**
     * 库存信息
     */
    private Stock stock;

}
