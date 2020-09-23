package cjy.mediator.demo.erp.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 中介者
 */
public class Mediator extends AbstractMediator {

    private static Logger logger = LoggerFactory.getLogger(Mediator.class);

    /**
     * 采购商品
     *
     * @param number 数量
     */
    @Override
    public void buy(int number) {

        //获取销售状态
        int saleStatus = sale.getSaleStatus();
        if (saleStatus >= 80) {
            logger.info("采购商品 {} 件", number);
            //按需采购
            stock.increase(number);
        } else {
            logger.info("采购商品 {} 件", number / 2);
            //折半采购
            stock.increase(number / 2);
        }

    }

    /**
     * 清库存
     */
    @Override
    public void clearStock() {
        //通知销售打折处理
        sale.offSale();
        //通知采购不再进货
        purchase.refuseBuyGoods();
    }

    /**
     * 销售商品
     *
     * @param number 数量
     */
    @Override
    public void sell(int number) {
        //检查库存商品数量是否足够
        int stockNumber = stock.getStockNumber();
        if (stockNumber < number) {
            logger.info("库存商品数量不足，进行采购");
            //进行采购
            purchase.buyGoods(number * 2);
        }
        //进行库存扣减
        logger.info("售出 {} 件商品",number);
        stock.decrease(number);
    }

    /**
     * 打折处理
     */
    @Override
    public void offSale() {
        logger.info("打骨折销售商品 {} 件",stock.getStockNumber());
    }
}
