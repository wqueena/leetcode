package medium;//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class SubarraySum_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0,temp=0;
        for (int n:nums){
            temp+=n;
            if (map.containsKey(temp-k)){
                res+=map.get(temp-k);
            }
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return res;

    }

    public static void main(String[] args) {
        SubarraySum_560 s=new SubarraySum_560();
        System.out.println(s.subarraySum(new int[]{1,1,1},2));
    }
}
/*
用map和前缀和来完成。key对应从开始元素到当前元素的和a，value对应这个和a的个数，
也就是有几段和为a的子段（这个子段是指从num[0]开始的。
 */