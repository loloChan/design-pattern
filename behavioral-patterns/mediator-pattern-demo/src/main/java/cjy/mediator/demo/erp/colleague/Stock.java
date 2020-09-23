package cjy.mediator.demo.erp.colleague;

import cjy.mediator.demo.erp.mediator.AbstractMediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存
 */
public class Stock extends AbstractColleague {

    private static Logger logger = LoggerFactory.getLogger(Stock.class);

    /**
     * 货物库存数量
     */
    private static int GOODS_NUMBER = 100;

    public Stock(AbstractMediator mediator) {
        super(mediator);
    }

    public void increase(int number) {
        GOODS_NUMBER += number;
        logger.info("商品当前库存量：{}",GOODS_NUMBER);
    }

    public void decrease(int number) {
        GOODS_NUMBER -= number;
        logger.info("商品当前库存量：{}",GOODS_NUMBER);
    }

    /**
     * 获取库存数量
     * @return
     */
    public int getStockNumber() {
        return GOODS_NUMBER;
    }

    /**
     * 清理库存。
     * 1、通知销售打折处理
     * 2、通知采购不再进货
     */
    public void clearStock() {
        mediator.clearStock();
    }
}
