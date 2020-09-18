package com.composite.demo.design.logic;

import com.composite.demo.design.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 逻辑过滤器
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue 决策值
     * @param treeNodeLinks 决策节点
     * @return 下一个节点id
     */
    Long filter(Object matterValue, List<TreeNodeLink> treeNodeLinks);

    /**
     * 获取决策值
     * @param treeId 树id
     * @param userId 用户id
     * @param decisionMatter 决策物料
     * @return
     */
    Object matterValue(Long treeId, String userId, Map<String, Object> decisionMatter);

}
