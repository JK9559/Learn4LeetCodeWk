package wkang.learn;
/*
* https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
* */
import java.util.Arrays;
import java.util.HashSet;

public class Problem003 {

    public static int lengthOfLongestSubstring1(String s){
        int res = 0;
        int left = -1;
        int[] chs = new int[256];
        Arrays.fill(chs,-1);
        for(int i = 0; i < s.length(); i++){
            left = Math.max(left,chs[s.charAt(i)]);
            chs[s.charAt(i)] = i;
            res = Math.max(res,i - left);
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res,set.size());
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring1("aaabbca");
        System.out.println(ans);
    }

}
