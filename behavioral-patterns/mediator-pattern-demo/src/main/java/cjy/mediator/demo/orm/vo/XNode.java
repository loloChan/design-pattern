package cjy.mediator.demo.orm.vo;

import lombok.Data;

import java.util.Map;

/**
 * <mapper></mapper>标签信息封装
 */
@Data
public class XNode {

    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 唯一标识符
     */
    private String id;

    /**
     * 参数类型
     */
    private String parameterType;

    /**
     * 返回值类型
     */
    private String resultType;

    /**
     * sql语句
     */
    private String sql;

    /**
     * 参数列表
     */
    private Map<Integer, String> parameter;

}
