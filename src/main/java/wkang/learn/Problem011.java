package wkang.learn;

import java.util.Arrays;

/**
 * @author kangwei
 * @date 2018/11/27
 * https://leetcode.com/problems/3sum-closest
 */
public class Problem011 {
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
