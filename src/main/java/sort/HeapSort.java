package sort;

import java.util.Arrays;

/**
 * @Author:queena
 * @Date:2020/5/112104
 * @Description:
 */
public class HeapSort {
    public int[] heapSort(int[] arrs){
        for (int i=arrs.length/2-1;i>=0;i--){
            sort(arrs,i,arrs.length);
        }
        for (int i=arrs.length-1;i>0;i--){
            swap(arrs,0,i);
            sort(arrs,0,i);
        }
        return arrs;
    }
    public void sort(int[] arrs,int start,int end){
        for (int i=2*start+1;i<end;i=i*2+1){
            if (i+1<end&&arrs[i+1]>arrs[i]){
                i=i+1;
            }
            if (arrs[start]<arrs[i]){
                swap(arrs,start,i);
                start=i;
            }

        }
    }
    public void swap(int[] arrs,int i,int j){
        int temp=arrs[i];
        arrs[i]=arrs[j];
        arrs[j]=temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        System.out.println(Arrays.toString(heapSort.heapSort(new int[]{3,5,3,2,7,11,9,6,1})));
    }
}
