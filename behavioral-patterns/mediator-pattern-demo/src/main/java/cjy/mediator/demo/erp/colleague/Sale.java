package cjy.mediator.demo.erp.colleague;

import cjy.mediator.demo.erp.mediator.AbstractMediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 销售
 */
public class Sale extends AbstractColleague {

    private static Logger logger = LoggerFactory.getLogger(Sale.class);

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 销售货物
     * @param number
     */
    public void sellGoods(int number) {
        mediator.sell(number);
    }

    /**
     * 获取销售热度
     *
     * @return
     */
    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int status = random.nextInt(100);
        logger.info("商品的销售情况为：{}", status);
        return status;
    }

    /**
     * 折价销售
     */
    public void offSale() {
        mediator.offSale();
    }
}
