package com.composite.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 树节点对象：节点/叶子节点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    /**
     * 树根id
     */
    private Long treeId;

    /**
     * 节点id
     */
    private Long treeNodeId;

    /**
     * 节点类型：1节点、2叶子
     */
    private Integer nodeType;

    /**
     * 节点值
     */
    private Object nodeValue;

    /**
     * 节点链接
     */
    private List<TreeNodeLink> treeNodeLinks;

    /**
     * 决策key,使用哪个决策过滤器
     */
    private String ruleKey;

    /**
     * 决策key描述
     */
    private String ruleDesc;

}
