package wkang.learn.part0;

import java.util.LinkedList;

/**
 * @author kangwei
 * @date 2018/12/4
 * https://leetcode.com/problems/valid-parentheses/
 * 栈 注意判断边界值 "[" "]" ""
 */
public class Problem020 {

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (0 == stack.size()) {
                    return false;
                }
                char reChar = stack.remove(stack.size() - 1);
                if (s.charAt(i) == ')' && reChar != '(') {
                    return false;
                }else if (s.charAt(i) == '}' && reChar != '{') {
                    return false;
                }else if (s.charAt(i) == ']' && reChar != '[') {
                    return false;
                }
            }
        }
        return 0 == stack.size();
    }


    public static void main(String[] args) {
        System.out.println(isValid("[]"));
    }
}
