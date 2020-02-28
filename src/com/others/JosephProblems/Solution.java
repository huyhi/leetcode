package com.others.JosephProblems;

import com.Util.DoubleLinkNode;
import com.Util.ListNode;

// 2020年腾讯WXG一面算法题目，约瑟夫环问题
public class Solution {

    // 当时面试时我的解法，选择一个环形单链表来模拟圆桌，十分笨的一个解法
    public void Solution1(int n, int s, int m) {
        DoubleLinkNode start = new DoubleLinkNode(-1),
                p = start,
                tmp,
                pre;

        int i = 0;
        while (i++ < n) {
            tmp = new DoubleLinkNode(i);
            p.next = tmp;
            tmp.pre = p;
            p = p.next;
        }
        start.next.pre = p;
        p.next = start.next;

        p = start.next;
        i = 1;
        while (i++ < s) {
            p = p.next;
        }

        i = 1;
        while (true) {
            while (i++ < m) {
                p = p.next;
            }
            tmp = p;
            p = p.next;
            if (p == tmp) {
                System.out.println(p.val);
                break;
            } else {
                System.out.println(tmp.val);
                pre = tmp.pre;
                pre.next = p;
                p.pre = pre;
                i = 1;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().Solution1(1, 1, 1);
    }
}
