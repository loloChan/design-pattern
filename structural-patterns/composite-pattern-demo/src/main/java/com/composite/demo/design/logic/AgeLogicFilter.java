package com.composite.demo.design.logic;

import java.util.Map;

/**
 * 年龄决策过滤器
 */
public class AgeLogicFilter extends BaseLogic {
    /**
     * 获取决策值
     *
     * @param treeId         树id
     * @param userId         用户id
     * @param decisionMatter 决策物料
     * @return
     */
    @Override
    public Object matterValue(Long treeId, String userId, Map<String, Object> decisionMatter) {
        return decisionMatter.get("age");
    }
}
