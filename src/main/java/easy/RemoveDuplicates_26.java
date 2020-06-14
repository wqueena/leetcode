package easy;

/**
 * @Author:queena
 * @Date:2020/5/261546
 * @Description:
 */
public class RemoveDuplicates_26 {
  public int removeDuplicates(int[] nums) {
    if(nums.length<=1){
      return nums.length;
    }
    int i=0,j=0;
    while(j<nums.length){
      while(j<nums.length&&nums[i]==nums[j]){
        j++;
      }
      if (j<nums.length){
        i++;
        nums[i]=nums[j];
        j++;
      }
    }
    return i+1;
  }

  public static void main(String[] args) {
    System.out.println(new RemoveDuplicates_26().removeDuplicates(new int[]{1,1}));
  }
}
