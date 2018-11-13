package wkang.learn;

/*
 * 字符串排序算法 高位优先的字符串排序MSD
 * */

public class StringSortMSD {

    private static int R = 256;
    private static int M = 15;

    public static void sort(String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(a, aux, 0, N - 1, 0);
    }

    public static void sort(String[] a, String[] aux, int low, int high, int d) {
        if (high <= low + M) {
            insertSort(a, low, high, d);
        }

        int[] cnt = new int[R + 2];
        for (int i = low; i <= high; i++) {
            cnt[charAt(a[i], d) + 2]++;
        }

        for (int i = 0; i <= R; i++) {
            cnt[i + 1] += cnt[i];
        }

    }

    public static void insertSort(String[] a, int low, int high, int d) {

    }

    public static int charAt(String a, int d) {
        if (d < a.length()) {
            return a.charAt(d);
        } else {
            return -1;
        }
    }
}