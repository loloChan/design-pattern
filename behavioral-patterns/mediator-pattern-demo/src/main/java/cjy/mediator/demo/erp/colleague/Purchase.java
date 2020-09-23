package cjy.mediator.demo.erp.colleague;

import cjy.mediator.demo.erp.mediator.AbstractMediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 采购
 */
public class Purchase extends AbstractColleague {

    private static Logger logger = LoggerFactory.getLogger(Purchase.class);

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 采购货物
     * @param number
     */
    public void buyGoods(int number) {
        mediator.buy(number);
    }

    /**
     * 不再采购
     */
    public void refuseBuyGoods() {
        logger.info("不再采购货物");
    }


}
