package cn.leetcode.medium;

public class _162_find_peak_element {

    public int findPeakElement(int[] nums) {
        // 创造新的数组并在左右两边各放一个无穷小的数来实现逻辑的统一
        // 如果不好实现，也可以通过先把边界条件排除，截取数据段来实现逻辑的统一

        int len = nums.length;
        // boundary case eliminate
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }


        return binSearch(1, nums.length - 2, nums);
    }


    public int binSearch(int low, int high, int[] nums) {

        if (low == high) {
            return low;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (nums[mid] < nums[mid - 1]) {
            return binSearch(low, mid - 1, nums);
        } else {
            return binSearch(mid + 1, high, nums);
        }
    }
}
