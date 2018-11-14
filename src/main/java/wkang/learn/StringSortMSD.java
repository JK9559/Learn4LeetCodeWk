package wkang.learn;

/*
 * �ַ��������㷨 ��λ���ȵ��ַ�������MSD
 * */

import java.util.Arrays;

public class StringSortMSD {

    // �ַ�����Ϊ256
    private static int R = 256;
    // ��������С�ڵ���15ʱ��ʹ�ò�����������ݽ�������
    private static int M = 15;


    public static void sort(String[] a) {
        int N = a.length;
        // ����һ������a�Ŀ���
        String[] aux = new String[N];
        // ����a���� ��������aux �����a��low��ʼ ��high �����ַ���ÿ���ַ������±�Ϊd
        sort(a, aux, 0, N - 1, 0);
    }

    private static void sort(String[] a, String[] aux, int low, int high, int d) {
        if (high <= low + M) {
            insertSort(a, low, high, d);
            return;
        }

        // ������һ��R+2������ һ����cnt[0]=0��ʾ��һ���ַ����±�0��ʼ
        // һ����cnt[1]����������ַ�(���������˳����ַ����ȵ��ַ���ӦֵΪ-1)
        int[] cnt = new int[R + 2];
        for (int i = low; i <= high; i++) {
            // ����ÿ���ַ����ֵ�Ƶ��
            cnt[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r <= R; r++) {
            // cnt[r+1]=cnt[r]+cnt[r+1] ��ʾ ��һ���ַ����±�=��һ���ַ����±�+��һ���ַ��ĳ��ָ���
            cnt[r + 1] += cnt[r];
        }

        for (int i = low; i <= high; i++) {
            // ����a���� ��aux���� ����ÿ���ַ���Ӧ�ô��ڵ�λ��(�����±�d)
            aux[cnt[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = low; i <= high; i++) {
            // ��aux���������(���������±��Ǽ�����(cnt����ÿ��ѭ������)���±�ÿ�δ�0��ʼ����i-low)�ź���ֵ��a
            a[i] = aux[i - low];
        }

        for (int r = 0; r < R; r++) {
            // �ݹ���������� ÿ��d+1����һλ [low + cnt[r],low + cnt[r + 1] - 1] Ϊǰd+1Ϊ��ͬ���ַ���
            sort(a, aux, low + cnt[r], low + cnt[r + 1] - 1, d + 1);
        }

    }

    private static void insertSort(String[] a, int low, int high, int d) {
        for (int i = low + 1; i <= high; i++) {
            if (less(a[i], a[i - 1], d)) {
                String tmp = a[i];
                int j;
                for (j = i; j > low && less(tmp, a[j - 1], d); j--) {
                    a[j] = a[j - 1];
                }
                a[j] = tmp;
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static int charAt(String a, int d) {
        // �����ַ���a��Ӧ�±�d��ֵ��������a�ĳ���ʱ������-1����֤����ͬǰ׺������£��̵��ַ�����С
        if (d < a.length()) {
            return a.charAt(d);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the",
                "shells", "she", "sells", "are", "surely", "seashells"};
        StringSortMSD.sort(a);
        System.out.println(Arrays.toString(a));
        //[are, by, sea, seashells, seashells, sells, sells, she, she, shells, shore, surely, the, the]
    }
}