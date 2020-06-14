package medium;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesis_22 {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gen(0,0,n,"");
        return list;
    }

    private void gen(int left,int right,int n,String s) {
        if (s.length()==2*n) {
            list.add(s);
        }
        if (left<n) {
            gen(left+1,right,n,s+'(');
        }
        if (left>right) {
            gen(left,right+1,n,s+')');
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis_22 solution=new GenerateParenthesis_22();
        System.out.println(solution.generateParenthesis(3));
    }

}
/*
用递归的方法，有两个条件
1.只有在左括号的数量小于n的时候才能插入左括号
2.只有在右括号的数量小于左括号数量的时候才能插入右括号
 */