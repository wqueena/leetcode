package offer;

/**
 * @Author:queena
 * @Date:2020/6/151031
 * @Description:
 */
public class HammingWeight_15 {
/*  public int hammingWeight(int n) {
    int result=0;
    while (n!=0){
      result+=n&1; //按位与操作，都为1的时候结果为1
      n>>>=1; //在java中无符号右移为>>>,相当于除以2
    }
    return result;
  }*/
  public int hammingWeight(int n) {
    int result=0;
    while (n!=0){
      result+=1;
      n&=(n-1);
    }
    return result;
  }
}

/*
方法一：比较常规，除以2，判断每一位是否为1
方法二：n-1即为将n最右边的1变为0，并将最右边的1后面的所有0变成1，
      所以将n&(n-1)即为每次找到最右边的1，计算后将最右边的1变成0
*/


