package com.test.stepdef.resolver;

import com.test.data.table.type.FruitType;
import com.test.data.table.type.TripleTextType;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableResolver {
    @DataTableType
    public TripleTextType getTripleTextEntity(Map<String, String> entity) {
        return new TripleTextType(entity.get("text1"), entity.get("text2"), entity.get("text3"));
    }

    @DataTableType
    public FruitType getFruitEntity(Map<String, String> entity) {
        return new FruitType(entity.get("fruit1"), Boolean.valueOf(entity.get("isFruit")));

    }

}
