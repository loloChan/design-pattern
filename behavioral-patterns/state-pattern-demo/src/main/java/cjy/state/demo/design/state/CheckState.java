package cjy.state.demo.design.state;

import cjy.state.demo.design.enumeration.Status;
import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 活动审核状态
 *
 * 待审核 -> 通过、拒绝、关闭
 *
 */
public class CheckState extends State {

    private Logger logger = LoggerFactory.getLogger(CheckState.class);

    /**
     * 活动提审
     *
     * @param activityInfo 活动信息
     * @return
     */
    @Override
    public Result arraignment(ActivityInfo activityInfo) {
        return new Result("400","待审核不可重复提审");
    }

    /**
     * 审核通过
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkPass(ActivityInfo activityInfo) {
        logger.info("activity state: {} -> {}",activityInfo.getActivityState(), Status.Pass);
        activityInfo.setActivityState(Status.Pass);
        return new Result("200","审核通过");
    }

    /**
     * 审核拒绝
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRefuse(ActivityInfo activityInfo) {
        logger.info("activity state: {} -> {}",activityInfo.getActivityState(), Status.Refuse);
        activityInfo.setActivityState(Status.Refuse);
        return new Result("200","审核拒绝");
    }

    /**
     * 审核撤销
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRevoke(ActivityInfo activityInfo) {
        logger.info("activity state: {} -> {}",activityInfo.getActivityState(), Status.Editing);
        activityInfo.setActivityState(Status.Editing);
        return new Result("200","审核撤销回到编辑状态");

    }

    /**
     * 活动关闭
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result close(ActivityInfo activityInfo) {
        logger.info("activity state: {} -> {}",activityInfo.getActivityState(), Status.Close);
        activityInfo.setActivityState(Status.Close);
        return new Result("200","活动审核关闭");
    }

    /**
     * 活动开启
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result open(ActivityInfo activityInfo) {
        return new Result("400","审核中不可开启活动");
    }

    /**
     * 活动执行
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result doing(ActivityInfo activityInfo) {
        return new Result("400","审核中不可执行活动");
    }
}
