package wkang.learn;

import java.util.*;

/**
 * @author kangwei
 * @date 2018/11/27
 * https://leetcode.com/problems/3sum
 */
public class Problem010 {

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int maxLen = nums.length, i = 0, befTarget = Integer.MAX_VALUE;
        int j, k;
        if (nums.length <= 0 || nums[0] > 0 || nums[maxLen - 1] < 0) {
            return new ArrayList<List<Integer>>(res);
        }
        while (i <= maxLen - 2) {
            int target = 0 - nums[i];
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && befTarget == target) {
                i++;
                continue;
            }
            j = i + 1;
            k = maxLen - 1;
            while (j < k) {
                befTarget = target;
                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    j++;
                    k--;
                }
            }
            i++;
        }
        return new ArrayList<List<Integer>>(res);
    }

    /**
     * @param nums
     * @return
     * 首先将数组排序，先确定一个值nums[i]，从该值之后的数组中查找两个值，使三个数字之和为0
     * 查找方式为设置两个指针从左往右，从右往左进行查找。如果和小于0，将左指针右移，大于零，将右指针向左移
     * 等于零时，存储，并且分别向左向右移动指针。
     * 优化：有重复的值，直接跳过，不做重复计算
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i = 0, noNeedLen = 2;
        Arrays.sort(nums);
        while (i < nums.length - noNeedLen) {
            int j = i + 1, k = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            while (j < k) {
                if (0 == nums[i] + nums[j] + nums[k]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
            while (i < nums.length - noNeedLen && nums[i] == nums[i - 1]) {
                i++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] abc = {-2, 0, 0, 2, 2};
        List<List<Integer>> res = threeSum(abc);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }

}
