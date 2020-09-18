package com.composite.demo.design.logic;

import com.composite.demo.design.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 抽象逻辑过滤器，提供基础/通用的服务
 */
public abstract class BaseLogic implements LogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue   决策值
     * @param treeNodeLinks 决策节点
     * @return 下一个节点id
     */
    @Override
    public Long filter(Object matterValue, List<TreeNodeLink> treeNodeLinks) {
        for (TreeNodeLink treeNodeLink : treeNodeLinks) {
            if (decisionLogic(matterValue, treeNodeLink)) {
                return treeNodeLink.getNodeIdTo();
            }
        }
        //TODO 抛出业务异常，决策失败
        return 0L;
    }

    /**
     * 获取决策值
     *
     * @param treeId         树id
     * @param userId         用户id
     * @param decisionMatter 决策物料
     * @return
     */
    @Override
    public abstract Object matterValue(Long treeId, String userId, Map<String, Object> decisionMatter);

    /**
     * treeNodeLink主要用于逻辑判断，根据决策值决定下一个节点。
     * @param matterValue 决策值
     * @param treeNodeLink 节点链接（用于决策）
     * @return
     */
    private boolean decisionLogic(Object matterValue, TreeNodeLink treeNodeLink) {

        boolean decision = false;
        //根据不同的决策类型进行决策
        switch (treeNodeLink.getRuleLimitType()) {
            case 1:
                //等值判断
                decision = matterValue.equals(treeNodeLink.getRuleLimitValue());
                break;
            case 2:
                // >
                if (treeNodeLink.getRuleLimitValue() instanceof Number && matterValue instanceof Number) {
                    Double judgeValue = (Double) treeNodeLink.getRuleLimitValue();
                    decision = (Double)matterValue > judgeValue;
                }
                break;
            case 3:
                if (treeNodeLink.getRuleLimitValue() instanceof Number && matterValue instanceof Number) {
                    Double judgeValue = (Double) treeNodeLink.getRuleLimitValue();
                    decision = (Double)matterValue < judgeValue;
                }
                // <
                break;
            case 4:
                // >=
                if (treeNodeLink.getRuleLimitValue() instanceof Number && matterValue instanceof Number) {
                    Double judgeValue = (Double) treeNodeLink.getRuleLimitValue();
                    decision = (Double)matterValue >= judgeValue;
                }
                break;
            case 5:
                // <=
                if (treeNodeLink.getRuleLimitValue() instanceof Number && matterValue instanceof Number) {
                    Double judgeValue = (Double) treeNodeLink.getRuleLimitValue();
                    decision = (Double)matterValue <= judgeValue;
                }
                break;

        }
        return decision;
    }
}
