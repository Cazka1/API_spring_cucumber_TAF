package com.test.scenario_context;

import com.test.scenario_context.enums.ScenarioContextEnum;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {

    @Getter
    ThreadLocal<Map<ScenarioContextEnum, Object>> scenarioContext = ThreadLocal.withInitial(HashMap::new);

    public <T> T setScenarioContext(ScenarioContextEnum key, T value) {
        scenarioContext.get().put(key, value);
        return value;
    }

    public <T> T getContext(ScenarioContextEnum key) {
        return (T) scenarioContext.get().get(key);
    }
//    public <T> void getScenarioContext(String key, Object recordsToAdd, Class<T> objectClass) {
//        Object rawObject = scenarioContext.get().get(key);
//if(rawObject == null && objectClass == List.class) {
//    rawObject = new ArrayList<T>();
//    List out = (List)
//}

}


