package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author:queena
 * @Date:2020/5/110920
 * @Description:
 */
public class MaxSlidingWindow_239 {
/*    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        Deque<Integer> window=new LinkedList<Integer>();
        for (int i=0;i<nums.length;i++){
            while (!window.isEmpty()&&nums[i]>=nums[window.peekLast()]){
                window.pollLast();
            }
            if (!window.isEmpty()&&window.peek()==i-k){
                window.poll();
            }
            window.offer(i);
            if (i>=k-1){
                res[i-k+1]=nums[window.peek()];
            }
        }
        return res;
    }*/

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        int[] left=new int[nums.length],right=new int[nums.length];
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if (i%k==0){
                max=nums[i];
            }
            else {
                max = Math.max(max, nums[i]);
            }
            left[i]=max;
        }
        max=nums[nums.length-1];
        for (int i=nums.length-1;i>-1;i--){
            if ((i+1)%k==0){
                max=nums[i];
            }
            else {
                max = Math.max(max, nums[i]);
            }
            right[i]=max;
        }
        for (int i=0;i<res.length;i++){
            res[i]=Math.max(left[i+k-1],right[i]);
        }
        return res;
    }

}

/*
方法一：用一个双端队列来记录滑动窗口内的元素的坐标，
每次判断如果队列尾的坐标对应的nums中的元素比当前元素小，则把相应坐标从队列中pollLast，
当队列头的坐标等于当前元素坐标减去k的时候（即队列头的元素应该要出滑动窗口了），poll，
将当前元素的坐标放入队列。
这可以保证队列中的头永远是滑动窗口中最大元素的坐标！！

方法二：用动态规划法，
将nums分成长为k的若干段（最后一段可能长度小于k），
left数组记录每一段从左边起的最大值（left[i]表示从这一段的最左边位置到i位置的最大值），
right数组记录每一段从右边起的最大值（right[i]表示从这一段的最右边位置到i位置的最大值），
每一个滑动窗口的最大值就是left中滑动窗口结束坐标 和 right中滑动窗口开始坐标的较大值。
 */