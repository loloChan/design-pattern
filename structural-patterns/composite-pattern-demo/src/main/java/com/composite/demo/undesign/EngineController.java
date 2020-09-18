package com.composite.demo.undesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 决策控制器
 */
public class EngineController {

    private static Logger logger = LoggerFactory.getLogger(EngineController.class);

    /**
     * 根据用户性别和年龄做决策
     * @param userId 用户id
     * @param userGender 用户性别
     * @param userAge 用户年龄
     * @return
     */
    public String process(String userId, String userGender, int userAge) {

        logger.info("ifelse实现用户的营销决策：userId={},userGender={},userAge={}");

        if ("man".equals(userGender)) {

            if (userAge < 25) {
                return "营销策略A";
            } else {
                return "营销策略B";
            }

        } else if ("woman".equals(userGender)) {
            if (userAge < 25) {
                return "营销策略C";
            } else {
                return "营销策略D";
            }
        }

        return null;
    }

}
