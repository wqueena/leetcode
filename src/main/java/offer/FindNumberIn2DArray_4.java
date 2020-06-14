package offer;

/**
 * @Author:queena
 * @Date:2020/5/272102
 * @Description:
 */
public class FindNumberIn2DArray_4 {
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    for (int i=0;i<matrix.length;i++){
      int left=0,right=matrix[0].length-1;
      while (left<=right){
        if (target==matrix[i][left]||target==matrix[i][right]){
          return true;
        }
        if (target<matrix[i][left]||target>matrix[i][right]){
          break;
        }
        left++;
        right--;
      }
    }
    return false;
  }

}
