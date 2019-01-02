package wkang.learn.part0;

/*
* https://leetcode.com/problems/regular-expression-matching
* */

public class Problem007 {
    public static boolean isMatch(String s, String p) {
        // �����ַ���s��p�ĳ���
        int lens = s.length(), lenp = p.length();
        // ����һ����ά���� �����ֵ���� ��s��pΪ��ʱ����Ϣ������ ���ж��ȳ��ȶ�1
        // ����Ҳ������ͬ ����dp���� dp[i][j] Ϊ��s��p��ͷ��ʼ ���ȷֱ�Ϊi��j�� ����ƥ�����
        // Ҳ����s[0,...,i-1] �� p[0,...,j-1] ��ƥ�����
        boolean[][] dp = new boolean[lens + 1][lenp + 1];
        // ��s��p�ֱ�Ϊ�����մ�ʱ ƥ�� ��ʼ��Ϊtrue
        dp[0][0] = true;
        // ��s��Ϊ�� pΪ��ʱ ��Ȼ��ƥ�� ��ʼ��Ϊfalse
        for (int i = 1; i < lens + 1; i++) {
            dp[i][0] = false;
        }
        // ��sΪ�� p��Ϊ��ʱ ���p��ǰ��ĩβ�ַ�(p[j-1])Ϊ'*'ʱ����ֵ�ɵ�ͬ�ڽ���ǰp���ĳ��ȼ���2λʱ��s��ǰ(�մ�)��ƥ��ֵ
        for (int j = 1; j < lenp + 1; j++) {
            dp[0][j] = (dp[0][j - 2] && '*' == p.charAt(j - 1) && j >= 2);
        }
        // ����dp[i][j]
        for (int i = 1; i < lens + 1; i++) {
            for (int j = 1; j < lenp + 1; j++) {
                // ��Ϊ����
                // 1�� ��p�ĵ�ǰ���һλ����'*'ʱ�������ȡs��p��ǰi-1���Ⱥ�j-1���Ƚ�����ٶԱ�s��p�ĵ�i-1��j-1λ
                // �Ƿ����� ��ͬ ���� p��j-1λ��'.'
                // 2�� ��p�ĵ�ǰ���һλ��'*'ʱ����Ϊ*����ƥ��0�Σ��Ͷ���0��
                // ��ƥ��0��ʱ dp[i][j] Ӧ���� ����Ϊi��s�ͳ���Ϊj-2��ƥ����
                // ��ƥ�����0��ʱ dp[i][j] �鿴p��'*'ǰһ���ַ� �Ƿ���s�����һ���ַ���ͬ����p��'*'ǰһλΪ'.'����ƥ��
                // ��������������ʱ ȡ����s[0,...,i-2]����Ϊi-1 ��p[0,...,j-1]����Ϊj �Ƿ�ƥ�� ���ƥ���� ��ô'*'����ƥ����1��
                if ('*' != p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)));
                }
            }
        }
        // ����ȡ����Ϊlens��s�ͳ���Ϊlenp��p�Ľ��
        return dp[lens][lenp];
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean fl = isMatch(s,p);
        System.out.println(fl);
    }
}
