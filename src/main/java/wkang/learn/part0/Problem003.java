package wkang.learn.part0;
/*
 *
 * */

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * @author wkang
 * @date 2019/02/12
 */
public class Problem003 {

    /**
     * @param s
     * @return
     * 滑动窗口法 记录两个指针，一个记录为i 不断向后遍历的指针 一个记录为left 记录在当前i的情况下不重复字串的最左端索引
     * 维护一个chs数组 首先初始化为-1 用来记录每个元素 在遍历到i的时候 出现的最后位置
     * left的移动规则 是 如果发现重复字符 则移动到重复字符的位置
     */
    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int left = -1;
        int[] chs = new int[256];
        Arrays.fill(chs, -1);
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, chs[s.charAt(i)]);
            chs[s.charAt(i)] = i;
            res = Math.max(res, i - left);

            System.out.println("left:" + left + " res:" + res + " i-left: " + (i - left));

        }

        System.out.println(Arrays.toString(chs));
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring1("aaabbcaa");
        System.out.println(ans);


    }

}
