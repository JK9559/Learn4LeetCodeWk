package wkang.learn;

/*
* https://leetcode.com/problems/container-with-most-water/
* */

public class Problem008 {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = Math.max(Math.min(height[i], height[j]) * (j - i), res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(h));
    }
}
