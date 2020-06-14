package offer;

import java.util.Arrays;

/**
 * @Author:queena
 * @Date:2020/5/272030
 * @Description:
 */
public class FindRepeatNumber_3 {
  public int findRepeatNumber(int[] nums) {
    Arrays.sort(nums);
    for (int i=0;i<nums.length;i++){
      if (i!=nums[i]){
        if (nums[i]==nums[nums[i]]){
          return nums[i];
        }
      }
    }
    return 0;
/*
        Set<Integer> set=new HashSet<>();
        for (int n:nums){
            if (set.contains(n)){
                return n;
            }
            set.add(n);
        }
        return 0;
*/
  }

}
/*
方法二的空间复杂度太高了
方法一利用了因为数字是在0-1之间的，所以可以先排序后判断坐标和值的对应关系
 */
