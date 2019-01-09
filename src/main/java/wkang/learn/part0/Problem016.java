package wkang.learn.part0;

import java.util.Arrays;

/**
 * @author kangwei
 * @date 2018/11/27
 * https://leetcode.com/problems/3sum-closest
 * 计算三个数之和 比较本次计算差diff和上一次计算的diff
 * 如果小于上一次的 则更新diff 并记录此时sum
 * 如果大于等于上一次的 如果sum小于target 左指针右移 如果sum大于target 右指针左移
 */
public class Problem016 {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res = nums[0];
        int i = 0;
        Arrays.sort(nums);
        while (i < nums.length) {

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target == sum) {
                    return target;
                } else {
                    if (Math.abs(target - sum) < diff) {
                        diff = Math.abs(target - sum);
                        if (target > sum) {
                            j++;
                            res = target - diff;
                        } else {
                            k--;
                            res = target + diff;
                        }
                    }else{
                        if (target > sum) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, -3};
        int target = 1;
        System.out.println(threeSumClosest(a, target));
    }
}
