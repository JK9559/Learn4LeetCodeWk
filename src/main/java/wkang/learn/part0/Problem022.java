package wkang.learn.part0;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kangwei
 * @date 2018/12/5
 * https://leetcode.com/problems/generate-parentheses/
 * 树 dfs 根为左括号 左不能大于n 遍历过程中 左不能小于右
 */
public class Problem022 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(n, 0, 0, "", res);
        return res;
    }

    public static void dfs(int n, int left, int right, String tmp, List<String> res) {
        if (n < left) {
            return;
        }
        if (left < right) {
            return;
        }
        if (n == left && n == right) {
            res.add(tmp);
        }
        dfs(n, left + 1, right, tmp + "(", res);
        dfs(n, left, right + 1, tmp + ")", res);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
