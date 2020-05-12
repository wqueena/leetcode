package easy;

import java.util.PriorityQueue;

/**
 * @Author:queena
 * @Date:2020/5/102025
 * @Description:
 */
public class KthLargest_703 {
    PriorityQueue<Integer> queue;
    int limit;
    public KthLargest_703(int k, int[] nums) {
        queue=new PriorityQueue<Integer>();
        limit=k;
        for (int num:nums){
            add(num);
        }

    }

    public int add(int val) {
        if (queue.size()<limit){
            queue.offer(val);
        }
        else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}

/*
用优先队列来存储，将小的放在队列头，
始终保持优先队列大小为k，用来存储前k大个元素，每次返回队列头即为第k大
 */