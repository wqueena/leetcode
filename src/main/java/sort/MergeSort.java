package sort;

import java.util.Arrays;

/**
 * @Author:queena
 * @Date:2020/5/211035
 * @Description:
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {5, 3,6,10,7,0,8, 4, 8, 2};
    //new MergeSort().mSort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(new MergeSort().mSort(arr,0,arr.length-1)));
  }

/*    public void mergeSort(int[] arr){
    mSort(arr,0,arr.length-1);
  }*/
  public int[] mSort(int[] arr,int left,int right){
    if (left>=right){
      return arr;
    }
    int mid=(left+right)/2;
    mSort(arr,left,mid);
    mSort(arr,mid+1,right);
    merge(arr,left,mid,right);
    return arr;
  }

  public void merge(int[] arrs,int left,int mid,int right){
    int i=left,j=mid+1,t=0;
    int[] temp=new int[right-left+1];
    while (i<=mid&&j<=right){
      if (arrs[i]<arrs[j]){
        temp[t++]=arrs[i++];
      }
      else {
        temp[t++]=arrs[j++];
      }
    }
    while (i<=mid){
      temp[t++]=arrs[i++];
    }
    while (j<=right){
      temp[t++]=arrs[j++];
    }
    for (int k=0;k<temp.length;k++){
      arrs[k+left]=temp[k];
    }
  }
}

