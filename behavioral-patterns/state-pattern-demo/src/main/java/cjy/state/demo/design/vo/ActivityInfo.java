package cjy.state.demo.design.vo;

import cjy.state.demo.design.enumeration.Status;
import lombok.Data;

import java.util.Date;

/**
 * 活动信息
 */
@Data
public class ActivityInfo {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动状态
     */
    private Enum<Status> activityState;

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;

}
