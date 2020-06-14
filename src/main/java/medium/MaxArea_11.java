package medium;

/**
 * @Author:queena
 * @Date:2020/5/261641
 * @Description:
 */
public class MaxArea_11 {
  public int maxArea(int[] height) {
    int left=0,right=height.length-1;
    int result=0;
    int temp;
    while (left<right){
      if (height[left]<=height[right]){
        temp=height[left];
        left++;
      }
      else {
        temp=height[right];
        right--;
      }
      result=Math.max(result,temp*(right-left+1));

    }
    return result;
  }

}
