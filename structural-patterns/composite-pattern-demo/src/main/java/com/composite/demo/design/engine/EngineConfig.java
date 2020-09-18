package com.composite.demo.design.engine;

import com.composite.demo.design.logic.AgeLogicFilter;
import com.composite.demo.design.logic.GenderLogicFilter;
import com.composite.demo.design.logic.LogicFilter;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 决策引起配置信息
 */
@Data
public class EngineConfig {

    protected static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    static {
        logicFilterMap.put("genderFilter", new GenderLogicFilter());
        logicFilterMap.put("ageFilter", new AgeLogicFilter());
    }

}
