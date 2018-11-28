package wkang.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kangwei
 * @date 2018/11/28
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 学到的点 判断字符串为空 digits == null || digits.length() <= 0
 */
public class Problem012 {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return new ArrayList<String>();
        }
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        // 将结果数组初始化为空(保证有值 length不为0)
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<String>();
            // 字典里取对应数字的字符串
            String str = dict[digits.charAt(i) - '0'];
            // 遍历对应字符串 将每个字符插入到结果res每个字符串之后
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
