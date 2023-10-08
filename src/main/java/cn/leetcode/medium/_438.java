package cn.leetcode.medium;

import java.util.*;

public class _438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> pCountMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCountMap.put(c, pCountMap.getOrDefault(c, 0) + 1);
        }

        int pLen = p.length();
        int left = 0, right = left + pLen - 1;
        char[] sArr = s.toCharArray();

        Map<Character, Integer> sCountMap = new HashMap<>();
        for (int i = left; i <= right; i++) {
            sCountMap.put(sArr[i], sCountMap.getOrDefault(sArr[i], 0) + 1);
        }

        int i = 0;
        while (true) {
            if (sCountMap.equals(pCountMap)) {
                res.add(i);
            }

            if (i + pLen == sArr.length) {
                break;
            }

            right = i + pLen;

            if (sCountMap.get(sArr[i]) == 1) {
                sCountMap.remove(sArr[i]);
            } else {
                sCountMap.put(sArr[i], sCountMap.get(sArr[i]) - 1);
            }

            sCountMap.put(sArr[right], sCountMap.getOrDefault(sArr[right], 0) + 1);

            i++;
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        new _438().findAnagrams(s, p);
    }
}
