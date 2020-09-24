package cjy.memento.demo.design;

import java.util.Map;

/**
 * 备忘录角色：负责存储Originator的内部状态
 */
public class Memento {

    /**
     * 成员变量名 -> 值
     */
    private Map<String, Object> stateMap;

    public Memento(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }

    public Map<String, Object> getStateMap() {
        return stateMap;
    }

}
