package wkang.learn;

/*
 * 字符串排序算法 高位优先的字符串排序MSD
 * */

import java.util.Arrays;

public class StringSortMSD {

    // 字符总数为256
    private static int R = 256;
    // 当数据量小于等于15时，使用插入排序对数据进行排序
    private static int M = 15;


    public static void sort(String[] a) {
        int N = a.length;
        // 设置一个数组a的拷贝
        String[] aux = new String[N];
        // 排序a数组 拷贝数组aux 排序从a的low开始 到high 排序字符在每个字符串里下标为d
        sort(a, aux, 0, N - 1, 0);
    }

    private static void sort(String[] a, String[] aux, int low, int high, int d) {
        if (high <= low + M) {
            insertSort(a, low, high, d);
            return;
        }

        // 设置了一个R+2的数组 一个是cnt[0]=0表示第一个字符从下标0开始
        // 一个是cnt[1]用来保存空字符(下面设置了超出字符长度的字符对应值为-1)
        int[] cnt = new int[R + 2];
        for (int i = low; i <= high; i++) {
            // 计算每个字符出现的频率
            cnt[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r <= R; r++) {
            // cnt[r+1]=cnt[r]+cnt[r+1] 表示 下一个字符的下标=上一个字符的下标+上一个字符的出现个数
            cnt[r + 1] += cnt[r];
        }

        for (int i = low; i <= high; i++) {
            // 遍历a数组 向aux数组 插入每个字符串应该存在的位置(根据下标d)
            aux[cnt[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = low; i <= high; i++) {
            // 将aux数组的内容(该数组是下标是计数的(cnt数组每轮循环重置)故下标每次从0开始，故i-low)排好序赋值回a
            a[i] = aux[i - low];
        }

        for (int r = 0; r < R; r++) {
            // 递归调用排序函数 每次d+1后移一位 [low + cnt[r],low + cnt[r + 1] - 1] 为前d+1为相同的字符串
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
        // 返回字符串a对应下标d的值，当超出a的长度时，返回-1，保证了相同前缀的情况下，短的字符串更小
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