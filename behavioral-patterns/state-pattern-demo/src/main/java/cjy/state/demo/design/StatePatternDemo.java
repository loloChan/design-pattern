package cjy.state.demo.design;

import cjy.state.demo.design.enumeration.Status;
import cjy.state.demo.design.state.StateHandler;
import cjy.state.demo.design.vo.ActivityInfo;
import cjy.state.demo.design.vo.Result;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class StatePatternDemo {

    private static Logger logger = LoggerFactory.getLogger(StatePatternDemo.class);

    public static void main(String[] args) {

        //初始化一个活动类
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(1L);
        activityInfo.setActivityName("全场五折购书！");
        activityInfo.setActivityState(Status.Editing);
        activityInfo.setBeginDate(new Date());
        activityInfo.setEndDate(new Date());

        Result result = null;

        StateHandler stateHandler = new StateHandler();
        //提审
        result = stateHandler.arraignment(activityInfo);
        logger.info("审核结果：{}", JSON.toJSONString(result));
        //尝试开启活动
        result = stateHandler.open(activityInfo);
        logger.info("审核结果：{}", JSON.toJSONString(result));
        //审核通过
        result = stateHandler.checkPass(activityInfo);
        logger.info("审核结果：{}", JSON.toJSONString(result));
        //开启活动
        result = stateHandler.open(activityInfo);
        logger.info("审核结果：{}", JSON.toJSONString(result));
        //执行活动
        result = stateHandler.doing(activityInfo);
        logger.info("审核结果：{}", JSON.toJSONString(result));
    }

}
