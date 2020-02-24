package com.lcof;

import com.leetcode.Util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Test {

    List<Integer> res = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] resArr = new int[res.size()];
        int i = 0;
        for (int item : res) {
            resArr[i++] = item;
        }

        return resArr;
    }

    void reverse(ListNode h) {
        if (h == null) {
            return;
        } else {
            reverse(h.next);
            res.add(h.val);
        }
    }
}
