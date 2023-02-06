package cn.leetcode.medium;

import java.util.Arrays;

public class _1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        if (properties == null || properties.length == 0) {
            return 0;
        }

        int res = 0;
        int len = properties.length;
        // 从大到小排序，atk 相同则按照 def 从大到小拍
        Arrays.sort(properties, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });

        int segmentMaxDef = properties[0][1];
        int i = 1;
        for (; i < len; i++) {
            if (properties[i][0] == properties[i - 1][0]) {
                segmentMaxDef = Math.max(segmentMaxDef, properties[i][1]);
            } else {
                break;
            }
        }
        int maxDef = segmentMaxDef;

        while (i < len) {
            if (properties[i][0] < properties[i - 1][0]) {
                maxDef = Math.max(maxDef, segmentMaxDef);
            }
            segmentMaxDef = Math.max(segmentMaxDef, properties[i][1]);
            if (properties[i][1] < maxDef) {
                res++;
            }
            i++;
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] properties = {{10, 1}, {5, 1}, {7, 10}, {4, 1}, {5, 9}, {6, 9}, {7, 2}, {1, 10}};
        new _1996().numberOfWeakCharacters(properties);
    }
}
