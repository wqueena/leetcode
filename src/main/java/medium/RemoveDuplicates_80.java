package medium;

/**
 * @Author:queena
 * @Date:2020/5/261608
 * @Description:
 */
public class RemoveDuplicates_80 {
  public int removeDuplicates(int[] nums) {
    int i=0;int size=1;
    for (int j=1;j<nums.length;j++){
      if (nums[i]==nums[j]){
        size++;
        if (size<3) {
          i++;
          nums[i]=nums[j];
          continue;
        }
      }
      if (nums[i]!=nums[j]){
        size=1;
        i++;
        nums[i]=nums[j];
        continue;
      }
    }
    return i+1;
  }

  public static void main(String[] args) {
    System.out.println(new RemoveDuplicates_80().removeDuplicates(new int[]{1,1,1,1,2,2,3}));
  }
}
