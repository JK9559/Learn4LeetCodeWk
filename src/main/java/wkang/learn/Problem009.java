package wkang.learn;

/*
* https://leetcode.com/problems/longest-common-prefix
* */

import java.util.Arrays;

public class Problem009 {
    // ������ַ����������ַ����������ǰ׺
    public static String longestCommonPrefix(String[] strs) {
        // �������ַ�������Ϊ�� ���ؿ�
        if (strs == null || strs.length == 0) {
            return "";
        }
        // ���ַ�������������� �����Ļ� ����ǰ�������Ĳ�������ֻ��Ҫ�����������ַ����Ϳ���
        Arrays.sort(strs);
        // ȡ�����ַ���������С�����ȽϷ�Χ
        int i = 0, lens = Math.min(strs[0].length(), strs[strs.length - 1].length());
        while (i < lens && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
            i++;
        }
        // �ó������ǰ׺
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] str={"flower","flow","flight"};

        System.out.println(longestCommonPrefix(str));

    }
}
