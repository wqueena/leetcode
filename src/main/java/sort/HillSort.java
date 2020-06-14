package sort;

import java.util.Arrays;

/**
 * @Author:queena
 * @Date:2020/5/211038
 * @Description:
 */
public class HillSort {
  public void hillSort(int[] nums){
    int d=nums.length-1;
    while (d>0){
      for (int i=d;i<nums.length;i++){
        int j=i;
        int target=nums[j];
        while (j>=d&&nums[j-d]>target){
          nums[j]=nums[j-d];
          j-=d;
        }
        if (j!=i){
          nums[j]=target;
        }
      }
      //      sort(nums,d);
      d=d/2;
    }
    System.out.println(Arrays.toString(nums));
  }
/*
  public void sort(int[] nums,int d){
    for (int i=d;i<nums.length;i++){
      int j=i;
      int target=nums[j];
      while (j>=d&&nums[j-d]>target){
        nums[j]=nums[j-d];
        j-=d;
      }
      if (j!=i){
        nums[j]=target;
      }
    }
  }
*/

  public static void main(String[] args) {
    new HillSort().hillSort(new int[]{3,7,5,9,1,6,2,10,8,8,7,16});
  }
}
