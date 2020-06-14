package medium;//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10000 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestWPI_1124 {
/*    public int longestWPI(int[] hours) {
        int ans=0;
        for (int i=0;i<hours.length;i++){
            hours[i] = hours[i]>8?1:-1;
        }
        for (int i=0;i<hours.length-ans;i++){
            int count=0;
            for (int j=i;j<hours.length;j++){
                count+=hours[j];
                if (count>0){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }*/
    public int longestWPI(int[] hours) {
        int ans=0;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<hours.length;i++){
            sum+=hours[i]>8?1:-1;
            if (sum>0){
                ans=i+1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
                if (map.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
        }
        return ans;
    }

}
/*
方法一为暴力
方法二为前缀和+哈希表记录
 */
