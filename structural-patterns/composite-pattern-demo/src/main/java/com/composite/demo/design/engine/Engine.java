package com.composite.demo.design.engine;

import com.composite.demo.design.vo.EngineResult;
import com.composite.demo.design.vo.TreeRoot;

import java.util.Map;

/**
 * 决策引擎接口
 */
public interface Engine {

    /**
     * 根据决策树进行决策
     * @param userId 用户id
     * @param treeId 决策树id
     * @param treeRoot 决策树树根节点
     * @param decisionMatter 决策物料
     * @return {@link EngineResult} 决策结果
     */
    EngineResult process(String userId, Long treeId, TreeRoot treeRoot, Map<String, Object> decisionMatter);

}
