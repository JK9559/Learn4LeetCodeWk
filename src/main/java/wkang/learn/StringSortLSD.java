package wkang.learn;

/*
 * �ַ��������㷨 ��λ���ȵ��ַ�������LSD
 * */

import java.util.Arrays;

public class StringSortLSD {
    // LSD�㷨�����ַ�������
    public static void LSDSort(String[] str, int W) {

        // �ַ�����ʾת��������һ����256������
        int R = 256;
        // ��Ҫ�Ƚ϶��ٸ��ַ���
        int N = str.length;
        // һ���洢�м���ʱ����������
        String[] strTmp = new String[N];
        int[] cnt = new int[R + 1];

        // �ӵ�λ��ʼ����ÿһ���ַ���
        for (int d = W - 1; d >= 0; d--) {
            // ����ÿ���ַ���һ�ĳ���Ƶ��
            for (int i = 0; i < N; i++) {
                cnt[str[i].charAt(d) + 1]++;
            }
            // ����ÿ���ַ�(��ʱ�ַ��Ѿ����� ˳����Ǵ�0-256������˳��) ��ʱ��cnt�����ʾ��ÿ���ַ�����ȷ��˳��
            // ��Ӧ�ÿ�ʼ��λ��(����) ascii��Ϊ0�ıض���λ��0��ʼ��Ϊ1�ıض���0(cnt[0])+cnt[0+1]��ʼ,��ʾΪcnt[1]
            // Ϊ2�ıض���cnt[1](1����ʼλ��)+cnt[1+1](1�ĳ���Ƶ��)��ʾΪcnt[2],��������cnt[r+1]=cnt[r]+cnt[r+1]
            // ��һ����ʼλ��=ǰһ����ʼλ��+ǰһ������Ƶ��
            for (int r = 0; r < R; r++) {
                cnt[r + 1] += cnt[r];
            }
            // ��ԭ����copy����ʱ������,���ݵ�ǰ�ַ���λ��(��һ�����ֵ��ַ�Ϊ����ʼλ�� ֮������ַ���ʼλ�ü�һ)
            // ���Կ���LSDΪԭ������
            for (int i = 0; i < N; i++) {
                strTmp[cnt[str[i].charAt(d)]++] = str[i];
            }
            // ����ʱ����copy��ԭ����
            for (int i = 0; i < N; i++) {
                str[i] = strTmp[i];
            }
            // ��ʼ��cnt����
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] = 0;
            }
        }
    }

    // LSD�㷨�����ַ�������
    public static void LSDSort2(String[] str, int W) {

        int R = 256;
        int N = str.length;
        String[] strTmp = new String[N];
        int[] cnt = new int[R + 1];


        // �ӵ�λ��ʼ����ÿһ���ַ���
        for (int d = W - 1; d >= 0; d--) {
            // ����ÿ���ַ��ĳ���Ƶ��
            for (int i = 0; i < N; i++) {
                cnt[(str[i].charAt(d))]++;
            }
            // ���������cnt[R]=0,cnt[R-1]=cnt[R]+cnt[R-1],...,cnt[0]=cnt[1]+cnt[0](ʵ����cnt[R]�������,��Ϊ
            // cntʵ��Ϊ0~R-1 ����������൱�ڽ��±������ƶ���һλ(+1))
            for (int r = R; r > 0; r--) {
                cnt[r - 1] += cnt[r];
            }
            // ��ԭ����copy����ʱ������,���ݵ�ǰ�ַ�(��Ҫ+1��������һ���ó����Ǻ�)��λ��(��һ�����ֵ��ַ�Ϊ����ʼλ�� ֮������ַ���ʼλ�ü�һ)
            // ���Կ���LSDΪԭ������
            for (int i = 0; i < N; i++) {
                strTmp[cnt[str[i].charAt(d) + 1]++] = str[i];
            }
            // ����ʱ����copy��ԭ����
            for (int i = 0; i < N; i++) {
                str[i] = strTmp[i];
            }
            // ��ʼ��cnt����
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[13];

        a[0] = "4PGC93\0";
        a[1] = "2IYE230";
        a[2] = "3CIO720";
        a[3] = "1ICK750";
        a[4] = "1OHV845";
        a[5] = "4JZY524";
        a[6] = "1ICK750";
        a[7] = "3CIO720";
        a[8] = "1OHV845";
        a[9] = "1OHV845";
        a[10] = "2RLA629";
        a[11] = "2RLA629";
        a[12] = "3ATW723";

        LSDSort(a, 7);

        System.out.println(Arrays.toString(a));

        String[] b = new String[13];

        b[0] = "4PGC93\0";
        b[1] = "2IYE230";
        b[2] = "3CIO720";
        b[3] = "1ICK750";
        b[4] = "1OHV845";
        b[5] = "4JZY524";
        b[6] = "1ICK750";
        b[7] = "3CIO720";
        b[8] = "1OHV845";
        b[9] = "1OHV845";
        b[10] = "2RLA629";
        b[11] = "2RLA629";
        b[12] = "3ATW723";

        LSDSort2(b, 7);

        System.out.println(Arrays.toString(b));

    }

}
