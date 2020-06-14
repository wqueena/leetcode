package easy;//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
public class SingleNumber_136 {
/*
    public int singleNumber(int[] nums) {
        int res=nums[0];
        for (int i=1;i<nums.length;i++){
            res=res^nums[i];
        }
        return res;
    }
*/
    public int singleNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);
        for (int i=0;i<nums.length-2;i+=2){
            if (nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
    private void quickSort(int[] nums,int left,int right){
        if (left>right){
            return;
        }
        int index=find(nums,left,right);
        quickSort(nums,left,index-1);
        quickSort(nums,index+1,right);
    }
    private int find(int[] nums,int left,int right){
        int p=nums[left];
        while (left<right){
            while (left<right&&nums[right]<=p){
                right--;
            }
            nums[left]=nums[right];
            while (left<right&&nums[left]>=p){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=p;
        return left;
    }
}

/*
方法一：按位异或操作，相同则为0，相反则为1，所以遍历一遍后就两两抵消，只剩出现一次的数了
方法二：先排序再比较，顺便复习快排，但时间复杂度有O(NlogN)
方法一较快
 */