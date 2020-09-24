package cjy.memento.demo.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MementoPatternDemo {

    private static Logger logger = LoggerFactory.getLogger(MementoPatternDemo.class);

    public static void main(String[] args) {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        //初始状态
        originator.setState1("矮矮");
        originator.setState2("试试");
        originator.setState3("滴滴");
        originator.setState4("翻翻");
        logger.info("初始状态：{}", JSON.toJSONString(originator));

        //创建备忘录
        Memento memento = originator.createMemento();
        caretaker.setMemento(memento);

        //更改状态
        originator.setState1("球球");
        originator.setState2("绾绾");
        originator.setState3("谔谔");
        originator.setState4("然然");
        logger.info("修改后状态：{}", JSON.toJSONString(originator));

        //利用备忘录复原
        originator.restoreMemento(caretaker.getMemento());
        logger.info("复原后状态：{}", JSON.toJSONString(originator));
    }

}
