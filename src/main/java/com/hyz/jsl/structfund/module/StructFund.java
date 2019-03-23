package com.hyz.jsl.structfund.module;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructFund {
    @SerializedName("id")
    public String id;

//    public static <T extends StructFund> Map<String, T> listToMap(List<T> list){
//        Map<String, T> map = new HashMap<>();
//        for (T t : list) {
//            map.put(t.id, t);
//        }
//        return map;
//    }
}
