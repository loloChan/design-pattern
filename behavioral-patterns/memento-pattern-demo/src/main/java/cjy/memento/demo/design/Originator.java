package cjy.memento.demo.design;

import lombok.Data;

import java.util.Map;

/**
 * 发起人角色：负责定义备份范围的状态
 */
@Data
public class Originator {

    //模拟发起者有多种状态
    private String state1;
    private String state2;
    private String state3;
    private String state4;

    /**
     * 创建备忘录
     * @return
     */
    public Memento createMemento() {
        Map<String, Object> stateMap = BeanUtils.backupProp(this);
        return new Memento(stateMap);
    }

    /**
     * 恢复备忘录状态
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        BeanUtils.restoreProp(this, memento.getStateMap());
    }

}
