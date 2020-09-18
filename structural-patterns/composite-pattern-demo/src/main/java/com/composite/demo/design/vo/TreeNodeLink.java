package com.composite.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 树节点链接对象，包含决策信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNodeLink {

    /**
     * 父节点id
     */
    private Long nodeIdFrom;

    /**
     * 子节点id
     */
    private Long nodeIdTo;

    /**
     * 决策类型
     */
    private Integer ruleLimitType;

    /**
     * 决策的标准(即决策的标准，用于和传入的决策值做比较)
     */
    private Object ruleLimitValue;

}
