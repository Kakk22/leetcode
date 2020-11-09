package com.cyf.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a “flatten” dictionary object, whose keys are dot-separated.
 * For example, { ‘A’: 1, ‘B.A’: 2, ‘B.B’: 3, ‘CC.D.E’: 4, ‘CC.D.F’: 5}.
 * Implement a function to transform it to a “nested” dictionary object.
 * In the above case, the nested version is like:
 * <p>
 * 给定map类型根据规则转换成map
 *
 * @author by cyf
 * @date 2020/11/9.
 */
public class toMap {
    private static void toNewMap(String key, Integer val, Map resultMap) {
        if (!key.contains(".")) {
            resultMap.put(key, val);
        } else {
            String beforeKey = key.substring(0, key.indexOf("."));
            String afterKey = key.substring(key.indexOf(".") + 1);
            HashMap<String, Object> newMap = new HashMap<>(8);
            if (!resultMap.containsKey(beforeKey)) {
                resultMap.put(beforeKey, newMap);
            } else {
                newMap = (HashMap<String, Object>) resultMap.get(beforeKey);
            }
            toNewMap(afterKey, val, newMap);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(8);
        map.put("A", 1);
        map.put("B.A", 2);
        map.put("B.B", 3);
        map.put("CC.D.E", 4);
        map.put("CC.D.F", 5);
        HashMap<String, Object> resultMap = new HashMap<>(8);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            toNewMap(entry.getKey(), entry.getValue(), resultMap);
        }
        System.out.println(resultMap.toString());
    }
}
