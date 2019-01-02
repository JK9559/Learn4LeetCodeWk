package wkang.learn.part0;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 * */

public class Problem004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        double rst = (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
        return rst;
    }

    /*
     * 查找数组nums1和数组nums2分别从i和j下标开始的，第K个数字(1开始计数)。如果当开始下标大于或者等于当前数组的长度
     * 那么直接返回另一个数组的相应位置数字。如果取第一个，则返回两个数组最小的当前头位置的数字。
     * 二分法查找两个数组的第K位数字：
     * 因为有两个数组，进行二分的话，两个数组从计算的头开始取各取目标的一半值。合起来就是整个整合好的数组的头部（top K个），
     * 如果前一个数组最大值比后一个数组的最大值还小的话那么合起来说明后一个数组的最大值在前一个数组最大值之后（递增排序），
     * 又因为除2操作是去尾的，所以说明真正的第K个元素一定不在前一个数组的前面，所以有了如下分法。
     * */

    static int findKth(int[] nums1, int i, int[] nums2, int j, int K) {
        if (i >= nums1.length) {
            return nums2[j + K - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + K - 1];
        }
        if (1 == K) {
            return Math.min(nums1[i], nums2[j]);
        }
        int rst1 = (i + K / 2 - 1 < nums1.length) ? nums1[i + K / 2 - 1] : Integer.MAX_VALUE;
        int rst2 = (j + K / 2 - 1 < nums2.length) ? nums2[j + K / 2 - 1] : Integer.MAX_VALUE;
        if (rst1 < rst2) {
            return findKth(nums1, i + K / 2, nums2, j, K - K / 2);
        } else {
            return findKth(nums1, i, nums2, j + K / 2, K - K / 2);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        double c = findMedianSortedArrays(a, b);
        System.out.println(c);

    }

}
