package cjy.state.demo.design.state;

import cjy.state.demo.design.enumeration.Status;
import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 状态处理器
 */
public class StateHandler {

    private static Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<>();

    public StateHandler() {

        stateMap.put(Status.Editing, new EditingState());
        stateMap.put(Status.Check, new CheckState());
        stateMap.put(Status.Pass, new PassState());
        stateMap.put(Status.Refuse, new RefuseState());
        stateMap.put(Status.Close, new CloseState());
        stateMap.put(Status.Open, new OpenState());
        stateMap.put(Status.Doing, new DoingState());

    }


    /**
     * 活动提审
     *
     * @param activityInfo 活动信息
     * @return
     */
    public Result arraignment(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.arraignment(activityInfo);
    }

    /**
     * 审核通过
     *
     * @param activityInfo
     * @return
     */
    public Result checkPass(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.checkPass(activityInfo);
    }

    /**
     * 审核拒绝
     *
     * @param activityInfo
     * @return
     */
    public Result checkRefuse(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.checkRefuse(activityInfo);
    }

    /**
     * 审核撤销
     *
     * @param activityInfo
     * @return
     */
    public Result checkRevoke(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.checkRevoke(activityInfo);
    }

    /**
     * 活动关闭
     *
     * @param activityInfo
     * @return
     */
    public Result close(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.close(activityInfo);
    }

    /**
     * 活动开启
     *
     * @param activityInfo
     * @return
     */
    public Result open(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.open(activityInfo);
    }

    /**
     * 活动执行
     *
     * @param activityInfo
     * @return
     */
    public Result doing(ActivityInfo activityInfo) {
        State state = stateMap.get(activityInfo.getActivityState());
        return state.doing(activityInfo);
    }
}
