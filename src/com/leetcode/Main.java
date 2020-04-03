package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>() {{
            put(1, 2);
            put(2, 5);
        }};

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
