package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author:queena
 * @Date:2020/5/112147
 * @Description:
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] nums1=nums;
        List<Integer> temp;
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            nums1[i]=-nums[i];
        }
        Arrays.sort(nums1);
        for (int i=0;i<nums1.length;i++){
            int left=0,right=nums.length-1;
            while (left<right) {
                if (nums1[left] + nums1[right] == -nums1[i]) {
                    if (left != i && right != i && left < right) {
                        temp = new ArrayList<>();
                        temp.add(-nums1[i]);
                        temp.add(-nums1[left]);
                        temp.add(-nums1[right]);
                        Collections.sort(temp);
                        if (!res.contains(temp)) {
                            res.add(temp);
                        }
                    }
                    left++;
                    right--;
                }
                else if (nums1[left] + nums1[right] > -nums1[i]) {
                    right = right - (right == i + 1 ? 2 : 1);
                }
                else if (nums1[left] + nums1[right] < -nums1[i]) {
                    left = left + (left == i - 1 ? 2 : 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum_15=new ThreeSum_15();
        System.out.println(threeSum_15.threeSum(new int[]{-4,-2,-1}));
    }
}
