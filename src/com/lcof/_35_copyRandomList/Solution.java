package com.lcof._35_copyRandomList;


import java.util.HashMap;

public class Solution {

    public Node copyRandomList(Node head) {
        Node start = new Node(-1), p = start, headCopy = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (head != null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);

            p.next = newNode;
            p = p.next;

            head = head.next;
        }

        p = start.next;
        head = headCopy;
        while (head != null) {
            Node tmp = map.get(head.random);
            p.random = tmp;

            p = p.next;
            head = head.next;
        }

        return start.next;
    }
}


class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
    }
}