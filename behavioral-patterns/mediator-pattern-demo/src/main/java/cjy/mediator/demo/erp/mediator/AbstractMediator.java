package cjy.mediator.demo.erp.mediator;

import cjy.mediator.demo.erp.colleague.Purchase;
import cjy.mediator.demo.erp.colleague.Sale;
import cjy.mediator.demo.erp.colleague.Stock;

/**
 * 抽象中介者类
 */
public abstract class AbstractMediator {

    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator() {
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }

    /**
     * 采购商品
     * @param number 数量
     */
    public abstract void buy(int number);

    /**
     * 清库存
     */
    public abstract void clearStock();

    /**
     * 销售商品
     * @param number 数量
     */
    public abstract void sell(int number);

    /**
     * 打折处理
     */
    public abstract void offSale();

}
