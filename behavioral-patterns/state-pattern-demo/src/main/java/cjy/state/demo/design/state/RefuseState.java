package cjy.state.demo.design.state;

import cjy.state.demo.design.enumeration.Status;
import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 审核拒绝状态
 *
 * 审核拒绝 -> 撤审、关闭
 */
public class RefuseState extends State {

    private static Logger logger = LoggerFactory.getLogger(RefuseState.class);

    /**
     * 活动提审
     *
     * @param activityInfo 活动信息
     * @return
     */
    @Override
    public Result arraignment(ActivityInfo activityInfo) {
        return new Result("400","审核拒绝，不可提审");
    }

    /**
     * 审核通过
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkPass(ActivityInfo activityInfo) {
        return new Result("400","审核拒绝，不可通过");
    }

    /**
     * 审核拒绝
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRefuse(ActivityInfo activityInfo) {
        return new Result("400","审核拒绝，不可重复审核拒绝");
    }

    /**
     * 审核撤销
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRevoke(ActivityInfo activityInfo) {
        logger.info("activity state : {} -> {}", activityInfo.getActivityState(), Status.Editing);
        activityInfo.setActivityState(Status.Editing);
        return new Result("200","审核撤销成功，回到编辑状态");
    }

    /**
     * 活动关闭
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result close(ActivityInfo activityInfo) {
        logger.info("activity state : {} -> {}",activityInfo.getActivityState(),Status.Close);
        activityInfo.setActivityState(Status.Close);
        return new Result("200","活动关闭成功");
    }

    /**
     * 活动开启
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result open(ActivityInfo activityInfo) {
        return new Result("400","审核拒绝，不可开启活动");
    }

    /**
     * 活动执行
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result doing(ActivityInfo activityInfo) {
        return new Result("400","审核拒绝，不可执行活动");
    }
}
