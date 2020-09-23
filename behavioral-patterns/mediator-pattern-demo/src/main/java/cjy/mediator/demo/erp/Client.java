package cjy.mediator.demo.erp;


import cjy.mediator.demo.erp.colleague.Purchase;
import cjy.mediator.demo.erp.colleague.Sale;
import cjy.mediator.demo.erp.colleague.Stock;
import cjy.mediator.demo.erp.mediator.AbstractMediator;
import cjy.mediator.demo.erp.mediator.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

    private static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {

        AbstractMediator mediator = new Mediator();

        //采购
        logger.info("------------采购部门采购商品------------");
        Purchase purchase = new Purchase(mediator);
        purchase.buyGoods(100);

        logger.info("------------销售部门销售商品------------");
        Sale sale = new Sale(mediator);
        sale.sellGoods(180);

        logger.info("------------库存部门清理库存------------");
        Stock stock = new Stock(mediator);
        stock.clearStock();

    }

}
