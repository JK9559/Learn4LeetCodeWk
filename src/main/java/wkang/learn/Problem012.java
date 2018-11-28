package wkang.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kangwei
 * @date 2018/11/28
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * ѧ���ĵ� �ж��ַ���Ϊ�� digits == null || digits.length() <= 0
 */
public class Problem012 {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return new ArrayList<String>();
        }
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        // ����������ʼ��Ϊ��(��֤��ֵ length��Ϊ0)
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<String>();
            // �ֵ���ȡ��Ӧ���ֵ��ַ���
            String str = dict[digits.charAt(i) - '0'];
            // ������Ӧ�ַ��� ��ÿ���ַ����뵽���resÿ���ַ���֮��
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < res.size(); k++) {
                    tmp.add(res.get(k) + str.charAt(j));
                }
            }
            res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        String dig = "";
        List<String> res = letterCombinations(dig);
        System.out.println(Arrays.asList(res));
    }
}
