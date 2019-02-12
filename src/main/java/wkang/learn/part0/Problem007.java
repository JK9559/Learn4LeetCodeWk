package wkang.learn.part0;


/**
 * https://leetcode.com/problems/reverse-integer
 * 翻转给定数字 input 130 output 31 input -12 output -21
 * 重点在于判断是否溢出
 * @author wkang
 * @date 2019/02/12
 */
public class Problem007 {
    public static int reverse(int x) {

        int res = 0;
        int temp;
        while (x != 0) {
            int tail = x % 10;
            temp = res * 10 + tail;
            //System.out.println(temp + ":" + tail);
            // judge whether res is flow out.
            if ((temp - tail) / 10 != res) {
                return 0;
            }
            res = temp;
            x = x / 10;
        }

        return res;
    }

    public static void main(String[] args) {
        int abc = reverse(-12);
        System.out.println(abc);
    }
}
