package com.composite.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 树根节点信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeRoot {

    /**
     * 树id
     */
    private Long treeId;

    /**
     * 树根节点id
     */
    private Long treeRootNodeId;

    /**
     * 树名
     */
    private String treeName;

    /**
     * 该树的节点id与节点映射表
     */
    private Map<Long, TreeNode> treeNodeMap = new HashMap<>();

}
