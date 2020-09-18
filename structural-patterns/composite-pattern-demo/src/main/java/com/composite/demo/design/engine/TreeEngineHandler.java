package com.composite.demo.design.engine;

import com.composite.demo.design.vo.EngineResult;
import com.composite.demo.design.vo.TreeNode;
import com.composite.demo.design.vo.TreeRoot;

import java.util.Map;

/**
 * 决策树引擎处理器
 */
public class TreeEngineHandler extends BaseEngine {
    /**
     * 根据决策树进行决策
     *
     * @param userId         用户id
     * @param treeId         决策树id
     * @param treeRoot       决策树树根节点
     * @param decisionMatter 决策物料
     * @return {@link EngineResult} 决策结果
     */
    @Override
    public EngineResult process(String userId, Long treeId, TreeRoot treeRoot, Map<String, Object> decisionMatter) {

        TreeNode resultNode = engineDecisionMaker(treeRoot, decisionMatter, userId);
        EngineResult engineResult = new EngineResult();
        engineResult.setResult(resultNode.getNodeValue());
        engineResult.setTreeId(resultNode.getTreeId());
        engineResult.setTreeNodeId(resultNode.getTreeNodeId());
        engineResult.setUserId(userId);
        return engineResult;
    }
}
