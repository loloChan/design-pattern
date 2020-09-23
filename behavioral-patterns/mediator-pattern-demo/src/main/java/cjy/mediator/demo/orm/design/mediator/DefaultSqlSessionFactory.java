package cjy.mediator.demo.orm.design.mediator;

/**
 * SqlSessionFactory 默认实现类
 *
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    /**
     * 配置信息
     */
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSqlSession() {
        return new DefaultSqlSession(configuration.getConnection(),configuration.getMapperElement());
    }
}
