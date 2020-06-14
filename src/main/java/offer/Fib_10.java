package offer;//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
// Related Topics 递归


//leetcode submit region begin(Prohibit modification and deletion)
class Fib_10 {
/*    public int fib(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        int[] help=new int[n];
        help[0]=0;
        help[1]=1;
        for (int i=2;i<n;i++){
            help[i]=(help[i-1]+help[i-2])%1000000007;
        }
        return (help[n-1]+help[n-2])%1000000007;
    }*/
    public int fib(int n) {
        if (n==0){
            return 0;
        }
        int a=0,b=1,temp;
        for (int i=0;i<n-1;i++){
            temp=b;
            b=(a+b)%1000000007;
            a=temp;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
