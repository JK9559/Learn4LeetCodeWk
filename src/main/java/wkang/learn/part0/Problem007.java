package wkang.learn.part0;

/*
* https://leetcode.com/problems/regular-expression-matching
* */

public class Problem007 {
    public static boolean isMatch(String s, String p) {
        // 保存字符串s和p的长度
        int lens = s.length(), lenp = p.length();
        // 申请一个二维数组 保存的值包含 当s和p为空时的信息，所以 行列都比长度多1
        // 意义也有所不同 对于dp数组 dp[i][j] 为从s和p的头开始 长度分别为i和j的 长度匹配情况
        // 也就是s[0,...,i-1] 和 p[0,...,j-1] 的匹配情况
        boolean[][] dp = new boolean[lens + 1][lenp + 1];
        // 当s和p分别为两个空串时 匹配 初始化为true
        dp[0][0] = true;
        // 当s不为空 p为空时 必然不匹配 初始化为false
        for (int i = 1; i < lens + 1; i++) {
            dp[i][0] = false;
        }
        // 当s为空 p不为空时 如果p当前的末尾字符(p[j-1])为'*'时，其值可等同于将当前p串的长度减少2位时和s当前(空串)的匹配值
        for (int j = 1; j < lenp + 1; j++) {
            dp[0][j] = (dp[0][j - 2] && '*' == p.charAt(j - 1) && j >= 2);
        }
        // 计算dp[i][j]
        for (int i = 1; i < lens + 1; i++) {
            for (int j = 1; j < lenp + 1; j++) {
                // 分为两类
                // 1是 当p的当前最后一位不是'*'时，结果是取s和p的前i-1长度和j-1长度结果，再对比s和p的第i-1和j-1位
                // 是否满足 相同 或者 p的j-1位是'.'
                // 2是 当p的当前最后一位是'*'时，因为*可以匹配0次，和多于0次
                // 当匹配0次时 dp[i][j] 应该是 长度为i的s和长度为j-2的匹配结果
                // 当匹配多于0次时 dp[i][j] 查看p的'*'前一个字符 是否与s的最后一个字符相同或者p的'*'前一位为'.'任意匹配
                // 当满足上述条件时 取决于s[0,...,i-2]长度为i-1 和p[0,...,j-1]长度为j 是否匹配 如果匹配了 那么'*'至少匹配了1次
                if ('*' != p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)));
                }
            }
        }
        // 最终取长度为lens的s和长度为lenp的p的结果
        return dp[lens][lenp];
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean fl = isMatch(s,p);
        System.out.println(fl);
    }
}
