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
     * ��������nums1������nums2�ֱ��i��j�±꿪ʼ�ģ���K������(1��ʼ����)���������ʼ�±���ڻ��ߵ��ڵ�ǰ����ĳ���
     * ��ôֱ�ӷ�����һ���������Ӧλ�����֡����ȡ��һ�����򷵻�����������С�ĵ�ǰͷλ�õ����֡�
     * ���ַ�������������ĵ�Kλ���֣�
     * ��Ϊ���������飬���ж��ֵĻ�����������Ӽ����ͷ��ʼȡ��ȡĿ���һ��ֵ�������������������Ϻõ������ͷ����top K������
     * ���ǰһ���������ֵ�Ⱥ�һ����������ֵ��С�Ļ���ô������˵����һ����������ֵ��ǰһ���������ֵ֮�󣨵������򣩣�
     * ����Ϊ��2������ȥβ�ģ�����˵�������ĵ�K��Ԫ��һ������ǰһ�������ǰ�棬�����������·ַ���
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
