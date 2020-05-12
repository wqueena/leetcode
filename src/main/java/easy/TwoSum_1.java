package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:queena
 * @Date:2020/5/112132
 * @Description:
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                res[0]=map.get(nums[i]);
                res[1]=i;
                return res;
            }
            map.put(target-nums[i],i);
        }
        return res;
    }
}
