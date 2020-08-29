package offer;//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问
// k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
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
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class CuttingRope_14_2 {
    public int cuttingRope(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        if (n==4) return 4;
        int a=n/3,b=n%3;
        long result=1;
        for (int i=0;i<a-1;i++){
            result=result*3;
            result=result%1000000007;
        }
        if (b==0){
            return (int)(result*3%1000000007);
        }
        if (b==1){
            return (int)((result*2%1000000007)*2%1000000007);
        } else {
            return (int)((result*3%1000000007)*2%1000000007);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,16));
        System.out.println(new CuttingRope_14_2().cuttingRope(90));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
