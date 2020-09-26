package cjy.state.demo.design.state;

import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;

/**
 * 状态抽象类
 * 活动状态变更
 * 1. 编辑中 -> 提审、关闭
 * 2. 审核通过 -> 拒绝、关闭、活动中
 * 3. 审核拒绝 -> 撤审、关闭
 * 4. 活动中 -> 关闭
 * 5. 活动关闭 -> 开启
 * 6. 活动开启 -> 关闭
 */
public abstract class State {

    /**
     * 活动提审
     * @param activityInfo 活动信息
     * @return
     */
    public abstract Result arraignment(ActivityInfo activityInfo);

    /**
     * 审核通过
     * @param activityInfo
     * @return
     */
    public abstract Result checkPass(ActivityInfo activityInfo);

    /**
     * 审核拒绝
     * @param activityInfo
     * @return
     */
    public abstract Result checkRefuse(ActivityInfo activityInfo);

    /**
     * 审核撤销
     * @param activityInfo
     * @return
     */
    public abstract Result checkRevoke(ActivityInfo activityInfo);

    /**
     * 活动关闭
     * @param activityInfo
     * @return
     */
    public abstract Result close(ActivityInfo activityInfo);

    /**
     * 活动开启
     * @param activityInfo
     * @return
     */
    public abstract Result open(ActivityInfo activityInfo);

    /**
     * 活动执行
     * @param activityInfo
     * @return
     */
    public abstract Result doing(ActivityInfo activityInfo);

}
