package cn.leetcode.medium;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _2034_stock_price_fluctuation {
}

class StockPrice {

    private Map<Integer, Integer> ts2price = new HashMap<>();
    private TreeMap<Integer, Integer> price2count = new TreeMap<>();
    private int latestTimestamp = -1;

    public StockPrice() {
    }

    public void update(int timestamp, int price) {
        latestTimestamp = Math.max(latestTimestamp, timestamp);

        Integer prePrice = ts2price.get(timestamp);
        if (prePrice != null) {
            Integer count = price2count.get(prePrice);
            if (count == 1) {
                price2count.remove(prePrice);
            } else {
                price2count.put(prePrice, count - 1);
            }
        }

        ts2price.put(timestamp, price);
        price2count.put(price, price2count.get(price) == null ? 1 : price2count.get(price) + 1);
    }

    public int current() {
        return ts2price.get(latestTimestamp);
    }

    public int maximum() {
        return price2count.lastKey();
    }

    public int minimum() {
        return price2count.firstKey();
    }
}

