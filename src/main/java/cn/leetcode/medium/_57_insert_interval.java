package cn.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class _57_insert_interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int intervalsLen = intervals.length;
        if (intervalsLen == 0) {
            return new int[][]{newInterval};
        }

        int leftIdx = -1, rightIdx = -1;
        int leftGapIdx = -1, rightGapIdx = -1;
        int leftVal = newInterval[0], rightVal = newInterval[1];
        // build result
        Deque<int[]> res = new ArrayDeque<>();

        // eliminate boundary case
        if (leftVal > intervals[intervalsLen - 1][1]) {
            res = toDeque(intervals);
            res.addLast(newInterval);
            return res.toArray(int[][]::new);
        }
        if (rightVal < intervals[0][0]) {
            res = toDeque(intervals);
            res.addFirst(newInterval);
            return res.toArray(int[][]::new);
        }
        if (leftVal < intervals[0][0]) {
            intervals[0][0] = leftVal;
        }
        if (rightVal > intervals[intervalsLen - 1][1]) {
            intervals[intervalsLen - 1][1] = rightVal;
        }

        // set leftIdx & leftIdx value
        for (int i = 0; i < intervalsLen; i++) {
            if (leftVal >= intervals[i][0] && leftVal <= intervals[i][1]) {
                leftIdx = i;
            }
            if (rightVal >= intervals[i][0] && rightVal <= intervals[i][1]) {
                rightIdx = i;
            }
        }

        // set leftGap & rightGap
        for (int i = 0; i < intervalsLen - 1; i++) {
            if (leftVal > intervals[i][1] && leftVal < intervals[i + 1][0]) {
                leftGapIdx = i;
            }
            if (rightVal > intervals[i][1] && rightVal < intervals[i + 1][0]) {
                rightGapIdx = i;
            }
        }

        // 4 cases
        if (leftGapIdx != -1 && rightGapIdx != -1) {
            res.add(new int[]{leftVal, rightVal});
            while (leftGapIdx >= 0) {
                res.addFirst(intervals[leftGapIdx--]);
            }
            while (++rightGapIdx < intervalsLen) {
                res.addLast(intervals[rightGapIdx]);
            }
        } else if (leftIdx != -1 && rightIdx != -1) {
            res.add(new int[]{intervals[leftIdx][0], intervals[rightIdx][1]});
            while (--leftIdx >= 0) {
                res.addFirst(intervals[leftIdx]);
            }
            while (++rightIdx < intervalsLen) {
                res.addLast(intervals[rightIdx]);
            }
        } else if (leftIdx != -1) { // && rightGapIdx != -1
            res.add(new int[]{intervals[leftIdx][0], rightVal});
            while (--leftIdx >= 0) {
                res.addFirst(intervals[leftIdx]);
            }
            while (++rightGapIdx < intervalsLen) {
                res.addLast(intervals[rightGapIdx]);
            }
        } else if (rightIdx != -1) {
            res.add(new int[]{leftVal, intervals[rightIdx][1]});
            while (leftGapIdx >= 0) {
                res.addFirst(intervals[leftGapIdx--]);
            }
            while (++rightIdx < intervalsLen) {
                res.addLast(intervals[rightIdx]);
            }
        }

        return res.toArray(int[][]::new);
    }


    public Deque<int[]> toDeque(int[][] arr) {
        Deque<int[]> res = new ArrayDeque<>();
        for (int[] i : arr) {
            res.addLast(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
        int[] newIntervals = new int[]{5, 11};

        new _57_insert_interval().insert(intervals, newIntervals);
    }
}
