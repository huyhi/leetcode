package cn.leetcode.medium;

public class _6_zigzag {

    public String convert(String s, int n) {
        if (n == 1) {
            return s;
        }

        int len = s.length();
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                int k = 0;
                while (k < len) {
                    sb.append(arr[k]);
                    k += n + (n - 2);
                }
            } else if (i == n - 1) {
                int k = n - 1;
                while (k < len) {
                    sb.append(arr[k]);
                    k += n + (n - 2);
                }
            } else {
                int col = 0;
                int k;

                while (true) {
                    if (col % 2 == 0) {
                        k = (2 * n - 2) * (col / 2) + i;
                    } else {
                        k = (2 * n - 2) * ((col / 2) + 1) - i;
                    }
                    if (k >= len) {
                        break;
                    }
                    sb.append(arr[k]);
                    col++;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String res = new _6_zigzag().convert("A", 1);

        System.out.println(res);
    }
}
