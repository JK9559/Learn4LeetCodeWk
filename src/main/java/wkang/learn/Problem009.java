package wkang.learn;

/*
* https://leetcode.com/problems/longest-common-prefix
* */

import java.util.Arrays;

public class Problem009 {
    // 求给定字符数组所有字符串的最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        // 若给定字符串数组为空 返回空
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 对字符串数组进行排序 这样的话 排最前和排最后的差异就最大，只需要分析这两个字符串就可以
        Arrays.sort(strs);
        // 取两个字符串长度最小的做比较范围
        int i = 0, lens = Math.min(strs[0].length(), strs[strs.length - 1].length());
        while (i < lens && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
            i++;
        }
        // 得出最长公共前缀
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] str={"flower","flow","flight"};

        System.out.println(longestCommonPrefix(str));

    }
}
