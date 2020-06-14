package easy;//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
public class MajorityElement_169 {
/*
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }
            else {
                map.put(n,1);
            }
            if (map.get(n)>nums.length/2){
                return n;
            }
        }
        return 0;
    }
*/
/*
    public int majorityElement(int[] nums) {
        int num=nums[0],count=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==num){
                count++;
            }
            else {
                count--;
                if (count==0){
                    count=1;
                    num=nums[i];
                }
            }
        }
        return num;
    }
*/
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums,0,nums.length-1);
    }
    private int countInRange(int[] nums,int num,int lo,int hi){
        int count=0;
        for (int i=lo;i<=hi;i++){
            if (nums[i]==num){
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums,int lo,int hi){
        if (lo==hi){
            return nums[lo];
        }

        int mid=(hi-lo)/2+lo;
        int left=majorityElementRec(nums,lo,mid);
        int right=majorityElementRec(nums, mid+1, hi);

        if (left==right){
            return left;
        }

        int leftCount=countInRange(nums,left,lo,hi);
        int rightCount=countInRange(nums,right,lo,hi);

        return leftCount>rightCount?left:right;
    }

    public static void main(String[] args) {
        MajorityElement_169 majorityElement_169=new MajorityElement_169();
        System.out.println(majorityElement_169.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

}
/*
方法一：用一个map来存储值和它的数量，当数量超过长度的一半的时候直接返回
方法二：因为这个众数的数量一定是多于一半的，所以这个数的数量减去其他所有数的数量一定大于0，
先将基准num设为数组的第一个元素，将计数设为1，遍历，如果数与基准相等，则计数+1，否则计数-1，
如果计数变为0的时候，将num设为当前遍历的元素，最后计数一定为正数，并且num就是这个众数。
方法三：分治递归。将数组分成两部分，如果a是整个数组的众数，那么a也一定至少是其中一部分的众数。
将数组分成左右两部分，求出两边的众数a1，a2，再选择众数；
用分治递归的方法直至所有子问题的长度都为1，则每个数就是子数组中的众数，直接返回，
再将左右子区间的合并，如果两边众数相同则返回，如果不同，再比较两个众数在整个区间出现的次数
 */