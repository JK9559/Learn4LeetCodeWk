package wkang.learn;

public class Problem005 {


    /*
    ʱ�临�Ӷ�ΪO(n^2)
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

    //ʱ�临�Ӷ�ΪO(n)
    //�������㷨
    //�ڸ����ַ���ǰ���Լ��м䶼����һ��������ֵ��ַ� ��#,����ǰ��ֱ����Ӳ����ظ����ַ���$��@
    //������ ��������ַ������������Ļ����ַ��� ��ʼλ��Ϊ (��Ӧ���뾶������-���뾶)/2 ����Ϊ ���뾶-1
    //�ؼ�����Ϊ��뾶������p,��ʽ p[i] = (mx > i) ? Math.min(p[2 * id - i], mx - i) : 1;
    //����mxΪ���ҵ��Ļ��Ĵ��ܵ�������Ҷ��±꣬idΪ�����Ĵ�������λ��,2*id-i��i����id�ĶԳƵ���±�
    //���mx>i ��p[i]=Math.min(p[2 * id - i], mx - i)
    // 1) ��� mx - i > p[j] ��ôp[i]=p[j]
    // 2) ��� mx - i <= p[j] ��ôp[i]=mx-i
    //����Ϊp[i]=1
    //������ �� rstR ��¼���뾶 rstCenter ��¼���뾶��Ӧ�ļӹ����ַ���������λ��
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
