package cjy.mediator.demo.erp.colleague;

import cjy.mediator.demo.erp.mediator.AbstractMediator;

/**
 * 抽象协作类
 */
public abstract class AbstractColleague {

    /**
     * 中介者
     */
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }

}
