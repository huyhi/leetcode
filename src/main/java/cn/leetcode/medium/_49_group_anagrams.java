package cn.leetcode.medium;

import java.util.*;

public class _49_group_anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;

        Map<String, List<String>> counterMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String originStr = strs[i];
            String sortedStr = sortStr(originStr);

            List<String> val = counterMap.get(sortedStr);
            if (val == null) {
                counterMap.put(sortedStr, new ArrayList<>(Collections.singletonList(originStr)));
            } else {
                val.add(originStr);
            }
        }

        return new ArrayList<>(counterMap.values());
    }


    public String sortStr(String str) {
        return str.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
