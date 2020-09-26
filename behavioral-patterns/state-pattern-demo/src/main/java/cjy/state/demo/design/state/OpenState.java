package cjy.state.demo.design.state;

import cjy.state.demo.design.enumeration.Status;
import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 活动开启状态
 *
 * 开启 -> 关闭
 */
public class OpenState extends State {

    private static Logger logger = LoggerFactory.getLogger(OpenState.class);

    /**
     * 活动提审
     *
     * @param activityInfo 活动信息
     * @return
     */
    @Override
    public Result arraignment(ActivityInfo activityInfo) {
        return new Result("400","开启状态，拒绝提审");
    }

    /**
     * 审核通过
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkPass(ActivityInfo activityInfo) {
        return new Result("400","开启状态，拒绝审核通过");
    }

    /**
     * 审核拒绝
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRefuse(ActivityInfo activityInfo) {
        return new Result("400","开启状态，拒绝审核拒绝");
    }

    /**
     * 审核撤销
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result checkRevoke(ActivityInfo activityInfo) {
        return new Result("400","开启状态，拒绝审核撤销");
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
        return new Result("400","开启状态，拒绝再开启");
    }

    /**
     * 活动执行
     *
     * @param activityInfo
     * @return
     */
    @Override
    public Result doing(ActivityInfo activityInfo) {
        logger.info("activity state : {} -> {}", activityInfo.getActivityState(), Status.Doing);
        activityInfo.setActivityState(Status.Doing);
        return new Result("200","活动执行成功！");
    }
}
