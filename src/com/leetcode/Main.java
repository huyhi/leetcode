package com.leetcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int item : arr) {
            int val = m.containsKey(item) ? m.get(item) + 1 : 1;
            m.put(item, val);
        }
        Set<Integer> s = new HashSet<>();
        for (int item : m.values()) {
            if (s.contains(item)) {
                return false;
            }
            s.add(item);
        }

        return true;
    }
}
