package wkang.learn;

public class Problem005 {


    /*
    时间复杂度为O(n^2)
    int len = 0, maxLength = 0, start = 0;

    public String longestPalindrome1(String s) {

        char[] arr = s.toCharArray();

        len = s.length();

        if (len <= 1) return s;
        for (int i = 0; i < len; i++) {
            i = helper(arr, i);
        }
        return s.substring(start, start + maxLength);
    }

    public int helper(char[] arr, int k) {

        int i = k - 1, j = k;
        while (j < len - 1 && arr[j] == arr[j + 1]) j++;
        int nextCenter = j++;

        while (i >= 0 && j < len && arr[i] == arr[j]) {
            i--;
            j++;
        }

        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            start = i + 1;
        }

        return nextCenter;
    }*/

    //时间复杂度为O(n)
    //马拉车算法
    //在给定字符串前后以及中间都增加一个不会出现的字符 如#,再在前后分别增加不会重复的字符如$和@
    //经试验 处理过的字符串如果查找最长的回文字符串 起始位置为 (对应最大半径的中心-最大半径)/2 长度为 最大半径-1
    //关键步骤为求半径的数组p,公式 p[i] = (mx > i) ? Math.min(p[2 * id - i], mx - i) : 1;
    //定义mx为已找到的回文串能到达的最右端下标，id为最大回文串的中心位置,2*id-i是i关于id的对称点的下标
    //如果mx>i 则p[i]=Math.min(p[2 * id - i], mx - i)
    // 1) 如果 mx - i > p[j] 那么p[i]=p[j]
    // 2) 如果 mx - i <= p[j] 那么p[i]=mx-i
    //否则为p[i]=1
    //本题中 用 rstR 记录最大半径 rstCenter 记录最大半径对应的加工后字符串的中心位置
    public static String longestPalindrome(String s) {

        StringBuilder t  = new StringBuilder("$#");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            t.append(s.charAt(i)).append("#");
        }
        t.append("@");
        int id = 0, mx = 0, rstCenter = 0, rstR = 0,lent = t.length();
        int[] p = new int[lent];
        for (int i = 1; i < lent -1; i++) {
            //System.out.println(i + ":" + mx + ":" + id);
            p[i] = (mx > i) ? Math.min(p[2 * id - i], mx - i) : 1;
            while (t.charAt(i - p[i]) == t.charAt(i + p[i]))
                ++p[i];
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (rstR < p[i]) {
                rstR = p[i];
                rstCenter = i;
            }
        }
        return s.substring((rstCenter - rstR) / 2, (rstCenter - rstR) / 2 + rstR - 1);
    }

    public static void main(String[] args) {
        String str = "abcb";
        String rstS = longestPalindrome(str);
        System.out.println(rstS);
    }
}
