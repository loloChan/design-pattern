package com.composite.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 决策信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineResult {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 决策树id
     */
    private Long treeId;

    /**
     * 对应的决策树叶子节点
     */
    private Long treeNodeId;

    /**
     * 决策结果
     */
    private Object result;

}
