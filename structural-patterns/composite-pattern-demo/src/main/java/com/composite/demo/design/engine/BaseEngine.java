package com.composite.demo.design.engine;

import com.composite.demo.design.logic.LogicFilter;
import com.composite.demo.design.vo.EngineResult;
import com.composite.demo.design.vo.TreeNode;
import com.composite.demo.design.vo.TreeNodeLink;
import com.composite.demo.design.vo.TreeRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 基础决策引擎，提供通用服务
 */
public abstract class BaseEngine extends EngineConfig implements Engine {

    private Logger logger = LoggerFactory.getLogger(BaseEngine.class);

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
    public abstract EngineResult process(String userId, Long treeId,
                                         TreeRoot treeRoot, Map<String, Object> decisionMatter);

    /**
     * 决策器
     * @param treeRoot 树根节点
     * @param decisionMatter 决策原料
     * @return
     */
    protected TreeNode engineDecisionMaker(TreeRoot treeRoot, Map<String, Object> decisionMatter, String userId) {

        Map<Long, TreeNode> treeNodeMap = treeRoot.getTreeNodeMap();

        Long treeRootNodeId = treeRoot.getTreeRootNodeId();

        TreeNode treeNode = treeNodeMap.get(treeRootNodeId);

        while ("1".equals(treeNode.getNodeType())) {

            List<TreeNodeLink> treeNodeLinks = treeNode.getTreeNodeLinks();
            //决策过滤器key
            String ruleKey = treeNode.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            Object matterValue = logicFilter.matterValue(treeNode.getTreeId(), userId, decisionMatter);

            Long nextNodeId = logicFilter.filter(matterValue, treeNodeLinks);

            logger.info("决策引擎 => {},treeId={},userId={},treeNodeId={},ruleKey={},matterValue={}",treeRoot.getTreeName(),
                    treeRoot.getTreeId(),userId,treeNode.getTreeNodeId(),ruleKey,matterValue);

            treeNode = treeNodeMap.get(nextNodeId);
        }

        return treeNode;

    }
}
