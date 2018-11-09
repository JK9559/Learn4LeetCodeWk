package wkang.learn;

/*
* https://leetcode.com/problems/reverse-integer
* */

public class Problem006 {
    public static int reverse(int x) {
        /*long tmp;
        if (x < 0) {
            tmp = (long)0 - x;
        } else {
            tmp = x;
        }

        String intStr = String.valueOf(tmp);
        String str2 = new StringBuffer(intStr).reverse().toString();
        long s = Long.parseLong(str2);
        long t = Integer.MAX_VALUE;
        if(s > t){
            return 0;
        }
        int r = Integer.parseInt(str2);
        if (x < 0) {
            return 0 - r;
        } else {
            return r;
        }*/
        int res = 0;
        int temp;
        while (x != 0) {
            int tail = x % 10;
            temp = res * 10 + tail;
            //System.out.println(temp + ":" + tail);
            if ((temp - tail) / 10 != res) // judge whether res is flow out.
                return 0;
            res = temp;
            x = x / 10;
        }

        return res;
    }

    public static void main(String[] args) {
        int abc = reverse(-114483648);
        System.out.println(abc);
    }
}
