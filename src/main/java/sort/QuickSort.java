package sort;


import java.util.Arrays;

/**
 * @Author:queena
 * @Date:2020/5/112022
 * @Description:
 */
public class QuickSort {
    public int[] quickSort(int[] arrs,int start,int end){
        if (start<end) {
            int p = getp(arrs, start, end);
            quickSort(arrs, start, p - 1);
            quickSort(arrs, p + 1, end);
        }
        return arrs;
    }

    public int getp(int[] arrs,int start,int end){
        int p=arrs[start];
        while (start<end) {
            while (start < end && p >= arrs[end]) {
                end--;
            }
            arrs[start]=arrs[end];
            while (start<end&&p<=arrs[start]){
                start++;
            }
            arrs[end]=arrs[start];
        }
        arrs[start]=p;
        return start;
    }

    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        System.out.println(Arrays.toString(quickSort.quickSort(new int[]{3,5,3,2,7,11,9,6,1},0,8)));
    }
}
