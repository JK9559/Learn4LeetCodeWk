package wkang.learn;

/*
 * 字符串排序算法 低位优先的字符串排序LSD
 * */

import java.util.Arrays;

public class StringSortLSD {
    // LSD算法排序字符串正序
    public static void LSDSort(String[] str, int W) {

        // 字符串表示转换成数字一共有256个数字
        int R = 256;
        // 需要比较多少个字符串
        int N = str.length;
        // 一个存储中间临时变量的数组
        String[] strTmp = new String[N];
        int[] cnt = new int[R + 1];

        // 从低位开始遍历每一个字符串
        for (int d = W - 1; d >= 0; d--) {
            // 计算每个字符加一的出现频率
            for (int i = 0; i < N; i++) {
                cnt[str[i].charAt(d) + 1]++;
            }
            // 计算每个字符(此时字符已经有序 顺序就是从0-256递增的顺序) 这时的cnt数组表示了每个字符在正确的顺序
            // 上应该开始的位置(索引) ascii码为0的必定从位置0开始，为1的必定从0(cnt[0])+cnt[0+1]开始,表示为cnt[1]
            // 为2的必定从cnt[1](1的起始位置)+cnt[1+1](1的出现频率)表示为cnt[2],依次类推cnt[r+1]=cnt[r]+cnt[r+1]
            // 下一个起始位置=前一个起始位置+前一个出现频率
            for (int r = 0; r < R; r++) {
                cnt[r + 1] += cnt[r];
            }
            // 将原数组copy到临时数组里,根据当前字符的位置(第一个出现的字符为其起始位置 之后这个字符起始位置加一)
            // 可以看到LSD为原地排序
            for (int i = 0; i < N; i++) {
                strTmp[cnt[str[i].charAt(d)]++] = str[i];
            }
            // 将临时数组copy回原数组
            for (int i = 0; i < N; i++) {
                str[i] = strTmp[i];
            }
            // 初始化cnt数组
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] = 0;
            }
        }
    }

    // LSD算法排序字符串倒序
    public static void LSDSort2(String[] str, int W) {

        int R = 256;
        int N = str.length;
        String[] strTmp = new String[N];
        int[] cnt = new int[R + 1];


        // 从低位开始遍历每一个字符串
        for (int d = W - 1; d >= 0; d--) {
            // 计算每个字符的出现频率
            for (int i = 0; i < N; i++) {
                cnt[(str[i].charAt(d))]++;
            }
            // 这里假设了cnt[R]=0,cnt[R-1]=cnt[R]+cnt[R-1],...,cnt[0]=cnt[1]+cnt[0](实际上cnt[R]不会出现,因为
            // cnt实际为0~R-1 所以这里的相当于将下标整体移动了一位(+1))
            for (int r = R; r > 0; r--) {
                cnt[r - 1] += cnt[r];
            }
            // 将原数组copy到临时数组里,根据当前字符(需要+1才能与上一步得出的吻合)的位置(第一个出现的字符为其起始位置 之后这个字符起始位置加一)
            // 可以看到LSD为原地排序
            for (int i = 0; i < N; i++) {
                strTmp[cnt[str[i].charAt(d) + 1]++] = str[i];
            }
            // 将临时数组copy回原数组
            for (int i = 0; i < N; i++) {
                str[i] = strTmp[i];
            }
            // 初始化cnt数组
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
