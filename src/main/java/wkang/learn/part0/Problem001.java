package wkang.learn.part0;
/*
* https://leetcode.com/problems/two-sum/description/
* */
import java.util.Arrays;
import java.util.HashMap;

public class Problem001 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 声明一个map用于查找数据
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            // 从前到后将数组的值放入map中，与target相减求目标值
            // 查找目标值rest是不是已经遍历到了(在map里)
            Integer a = map.get(nums[i]);
            if(null == a){
                map.put(nums[i],i);
            }
            int rest = target - nums[i];
            a = map.get(rest);
            // 如果已经遍历到了 并且后值大于前值 那么可以返回，因为每个值不能使用两次
            if(null != a && a != i){
                res[0] = a;
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res;
        int[] nums = {3,2,4};
        res = new Problem001().twoSum(nums,6);
        System.out.println(Arrays.toString(res));
    }
}
