package medium;

/**
 * @Author:queena
 * @Date:2020/5/181651
 * @Description:
 */
public class MaxProduct_152 {
  public int maxProduct(int[] nums) {
    if (nums.length==0){
      return 0;
    }
    int result=nums[0];
    int max=nums[0],min=nums[0];
    for (int i=1;i<nums.length;i++){
      int temp=max;
      max=Math.max(max*nums[i],Math.max(min*nums[i],nums[i]));
      min=Math.min(min*nums[i],Math.min(temp*nums[i],nums[i]));
      result=Math.max(result,max);
    }
    return result;
  }

  public static void main(String[] args) {
    MaxProduct_152 maxProduct_152=new MaxProduct_152();
    System.out.println(maxProduct_152.maxProduct(new int[]{-4,-3,-2}));
  }
}
