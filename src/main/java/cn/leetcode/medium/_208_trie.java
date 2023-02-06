package cn.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _208_trie {

}

class Trie {

    Map<Character, Trie> mapper = new HashMap<>();
    boolean endFlag = false;

    public Trie() {
    }


    public void insert(String word) {
        if (word == null) {
            return;
        }

        Trie searchNode = this;
        for (char item : word.toCharArray()) {
            if (!searchNode.mapper.containsKey(item)) {
                searchNode.mapper.put(item, new Trie());
            }
            searchNode = searchNode.mapper.get(item);
        }
        searchNode.endFlag = true;
    }


    public boolean search(String word) {
        Trie searchNode = this;

        for (char item:  word.toCharArray()) {
            if (!searchNode.mapper.containsKey(item)) {
                return false;
            }
            searchNode = searchNode.mapper.get(item);
        }
        return searchNode.endFlag;
    }


    public boolean startsWith(String prefix) {
        Trie searchNode = this;
        for (char item : prefix.toCharArray()) {
            if (!searchNode.mapper.containsKey(item)) {
                return false;
            }
            searchNode = searchNode.mapper.get(item);
        }
        return true;
    }
}
