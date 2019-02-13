package wkang.learn.part0;


/**
 * https://leetcode.com/problems/container-with-most-water/
 * 给定一组非负数的数组 按顺序在数轴上排列 直线的高度为数字的大小 计算任意两条直线与其对应位置 围成的图形 能盛水的最大容量
 * 定义两个指针指向两端 计算和上次相比本次的面积 移动左边或者右边的指针
 * @date 2019/02/13
 * @author wkang
 */
public class Problem011 {
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
