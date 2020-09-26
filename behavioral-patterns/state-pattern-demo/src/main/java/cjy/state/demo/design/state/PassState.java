package cjy.state.demo.design.state;

import cjy.state.demo.design.enumeration.Status;
import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 审核通过状态
 *
 * 审核通过 -> 关闭活动、开启活动
 */
public class PassState extends State {

    private Logger logger = LoggerFactory.getLogger(PassState.class);

    /**
     * 活动提审
     *
     * @param activityInfo 活动信息
     * @return
     */
    @Override
    public Result arraignment(ActivityInfo activityInfo) {
        return new Result("400","审核通过不可提审");
    }

    /**
     * 审核通过
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkPass(ActivityInfo activityInfo) {
        return new Result("400","不可重复审核");
    }

    /**
     * 审核拒绝
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRefuse(ActivityInfo activityInfo) {
        return new Result("400","审核已通过，不可拒绝");
    }

    /**
     * 审核撤销
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRevoke(ActivityInfo activityInfo) {
        return new Result("400","审核已通过，不可撤销");
    }

    /**
     * 活动关闭
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result close(ActivityInfo activityInfo) {
        logger.info("activity state : {} -> {}", activityInfo.getActivityState(), Status.Close);
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
        logger.info("activity state : {} -> {}", activityInfo.getActivityState(), Status.Open);
        activityInfo.setActivityState(Status.Open);
        return new Result("200","活动开启成功");
    }

    /**
     * 活动执行
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result doing(ActivityInfo activityInfo) {
        return new Result("400","审核通过不可执行活动");
    }
}
