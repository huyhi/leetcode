package cn.leetcode.medium;

public class _165_compare_version {

    private final int BIG = 1, EQUALS = 0, SMALL = -1;

    public int compareVersion(String version1, String version2) {
        String[] ver1Strings = version1.split("\\.");
        String[] ver2Strings = version2.split("\\.");

        for (int i = 0; i < Math.max(ver1Strings.length, ver2Strings.length); i++) {
            int ver1Item = i >= ver1Strings.length ? 0 : toInt(ver1Strings[i]);
            int ver2Item = i >= ver2Strings.length ? 0 : toInt(ver2Strings[i]);
            if (ver1Item > ver2Item) {
                return BIG;
            }
            if (ver1Item < ver2Item) {
                return SMALL;
            }
        }

        return EQUALS;
    }


    private int toInt(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                continue;
            }
            return Integer.parseInt(a.substring(i));
        }
        return 0;
    }
}
