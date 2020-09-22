package cjy.iterator.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 职员信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Employee {

    /**
     * 用户id，同时充当组织树节点的节点id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 所属上司Id
     */
    private Long parentId;

    /**
     * 描述
     */
    private String desc;

}
