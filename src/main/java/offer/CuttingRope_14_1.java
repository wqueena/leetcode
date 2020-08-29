package offer;
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CuttingRope_14_1 {
/*
    public int cuttingRope(int n) {
        int result=1;
        if (n==2){
            return result;
        }
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        for (int i=3;i<=n;i++){
            Collections.sort(list);
            int temp1=list.get(0)+1;
            for (int j=1;j<list.size();j++){
                temp1*=list.get(j);
            }
            int a=i/(list.size()+1),b=i%(list.size()+1);
            int temp2=1;
            List<Integer> tempList=new ArrayList<>();

            for (int j=0;j<b;j++){
                temp2*=(a+1);
                tempList.add(a+1);
            }
            for (int j=0;j<(list.size()+1)-b;j++){
                temp2*=a;
                tempList.add(a);
            }
            if (temp1>=temp2){
                result=temp1;
                list.set(0,list.get(0)+1);
            } else {
                result=temp2;
                list=tempList;
            }
        }
        return result;
    }
*/
/*    public int cuttingRope(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        if (n==4) return 4;
        int a=n/3,b=n%3;
        if (b==0){
            return (int) Math.pow(3,a);
        }
        if (b==1){
            return (int) Math.pow(3,a-1)*4;
        } else {
            return (int) Math.pow(3,a)*2;
        }
    }*/
    public int cuttingRope(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        int[] results=new int[n+1];
        results[0]=0;
        results[1]=1;
        results[2]=2;
        results[3]=3;
        for (int i=4;i<=n;i++){
            for (int j=1;j<=i/2;j++){
                results[i]=results[j]*results[i-j]>results[i]?results[j]*results[i-j]:results[i];
            }
        }
        return results[n];
    }

    public static void main(String[] args) {
        System.out.println(new CuttingRope_14_1().cuttingRope(58));
    }
}
//方法一：用动态规划，每次判断是否要多剪一次
//方法二：当每段绳子长度为3的时候乘积最大(最快)
//方法三：动态规划，f(n)=max(f(i)*f(n-i))
