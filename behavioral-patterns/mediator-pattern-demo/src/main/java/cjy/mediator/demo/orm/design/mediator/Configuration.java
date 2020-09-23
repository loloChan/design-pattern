package cjy.mediator.demo.orm.design.mediator;

import cjy.mediator.demo.orm.vo.XNode;
import lombok.Data;

import java.sql.Connection;
import java.util.Map;

/**
 * xml文件配置类
 */
@Data
public final class Configuration {

    /**
     * 数据库连接
     */
    private Connection connection;

    /**
     * mapper节点信息
     */
    private Map<String, XNode> mapperElement;

    /**
     * 数据源信息
     */
    private Map<String, String> dataSource;

}
