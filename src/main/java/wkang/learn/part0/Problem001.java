package wkang.learn.part0;
/*
* https://leetcode.com/problems/two-sum/description/
* */
import java.util.Arrays;
import java.util.HashMap;

public class Problem001 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // ����һ��map���ڲ�������
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            // ��ǰ���������ֵ����map�У���target�����Ŀ��ֵ
            // ����Ŀ��ֵrest�ǲ����Ѿ���������(��map��)
            Integer a = map.get(nums[i]);
            if(null == a){
                map.put(nums[i],i);
            }
            int rest = target - nums[i];
            a = map.get(rest);
            // ����Ѿ��������� ���Һ�ֵ����ǰֵ ��ô���Է��أ���Ϊÿ��ֵ����ʹ������
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
