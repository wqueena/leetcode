package offer;//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Exist_12 {
    public boolean exist(char[][] board, String word) {
        if (board.length==0){
            return false;
        }
        boolean result=false;
        int[][] visited=new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    result=helper(board,i,j,0, word,visited);
                    if (result==true){
                        return true;
                    }
                }
            }
        }
        return result;
    }
    int[] dir={-1,0,1,0,-1};
    public boolean helper(char[][] board,int x,int y,int index,String word,int[][] visitd){
        if (index>=word.length()||board[x][y]!=word.charAt(index)){
            return false;
        }
        visitd[x][y]=1;
        for (int i=0;i<4;i++){
            if (x+dir[i]<0||x+dir[i]>=board.length||y+dir[i+1]<0||y+dir[i+1]>=board[0].length||visitd[x+dir[i]][y+dir[i+1]]==1){
                continue;
            } else {
                if (helper(board, x + dir[i], y + dir[i + 1], index + 1, word, visitd)){
                    return true;
                }
            }
        }
        visitd[x][y]=0;
        if (index==word.length()-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Exist_12 solution=new Exist_12();
        System.out.println(solution.exist(new char[][]{{'c','a','a'},{'a','a','a'},{'b','c','d'}},"aab"));
    }
}
//更简洁的方法

/*
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length==0){
            return false;
        }
        boolean result=false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    result=helper(board,i,j,0, word);
                    if (result==true){
                        return true;
                    }
                }
            }
        }
        return result;
    }
    boolean result;
    public boolean helper(char[][] board,int x,int y,int index,String word){
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != word.charAt(index))
            return false;
        if (index==word.length()-1){
          return true;
        }
        char temp=board[x][y];
        board[x][y]=1;
        result=helper(board,x+1,y,index+1,word)||helper(board,x-1,y,index+1,word)||helper(board,x,y+1,index+1,word)||helper(board,x,y-1,index+1,word);
        board[x][y]=temp;
        return result;
    }
}
*/

//leetcode submit region end(Prohibit modification and deletion)
