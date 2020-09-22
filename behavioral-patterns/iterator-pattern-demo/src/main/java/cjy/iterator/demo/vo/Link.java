package cjy.iterator.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 组织树链接节点
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Link {

    /**
     * 子节点id
     */
    private Long childId;

    /**
     * 父节点id
     */
    private Long parentId;

}
