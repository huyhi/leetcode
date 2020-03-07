package com.leetcode._146_LRUCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private int currentCapacity = 0;
    private Map<Integer, LNode> map = new HashMap<>();
    private LNode head;
    private LNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new LNode(-1, -1);
        this.tail = new LNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * 如果存在，就插入到头部
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            LNode node = map.get(key);
            removeNode(node);
            insertToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // 如果key存在
        if (map.containsKey(key)) {
            LNode moved = map.get(key);
            moved.val = value;
            map.put(key, moved);
            removeNode(moved);
            insertToHead(moved);
        } else {
            // key 不存在，分两者情况讨论，容量足够和不足够
            if (currentCapacity < capacity) {
                currentCapacity++;
            } else {
                int removedKey = eliminateLast();
                map.remove(removedKey);
            }
            LNode inserted = new LNode(key, value);
            map.put(key, inserted);
            insertToHead(inserted);
        }
    }

    public void insertToHead(LNode node) {
        LNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void removeNode(LNode removed) {
        LNode prev = removed.prev, next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public int eliminateLast() {
        LNode removed = tail.prev, prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
        return removed.key;
    }
}


class LNode {
    int key, val;
    LNode prev = null;
    LNode next = null;

    public LNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
