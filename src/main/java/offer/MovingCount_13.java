package offer;//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MovingCount_13 {
    //递推法
/*    public int movingCount(int m, int n, int k) {
        int result=0;
        if (m==0){
            return result;
        }
        int[][] visited=new int[m][n];
        for (int i=0;i<n;i++){
            if (i/10+i%10>k){
                break;
            }
            visited[0][i]=1;
            result++;
        }
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                if (i/10+i%10+j/10+j%10<=k){
                    if ((i-1>=0&&visited[i-1][j]==1)||(j-1>=0&&visited[i][j-1]==1)){
                        visited[i][j]=1;
                        result++;

                    }
                }
            }
        }
        return result;
    }*/
    //dfs
/*
    int[][] visited;
    public int movingCount(int m, int n, int k) {
        visited=new int[m][n];
        return dfs(m,n,0,0,0,0,k);
    }
    public int dfs(int m,int n,int i,int j,int si,int sj,int k){
        if (i>=m||j>=n||si+sj>k||visited[i][j]==1){
            return 0;
        }
        visited[i][j]=1;
        int res1=dfs(m,n,i+1,j,(i+1)%10!=0?si+1:si-8,sj,k);
        int res2=dfs(m,n,i,j+1,si,(j+1)%10!=0?sj+1:sj-8,k);
        return 1+res1+res2;
    }
*/
    //bfs
    public int movingCount(int m, int n, int k) {
        int[][] visited=new int[m][n];
        int result=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        while (queue.size()>0){
            int[] x=queue.poll();
            if (x[0]>=m||x[1]>=n||x[2]+x[3]>k||visited[x[0]][x[1]]==1){
                continue;
            }
            visited[x[0]][x[1]]=1;
            result++;
            queue.add(new int[]{x[0]+1,x[1],(x[0]+1)%10!=0?x[2]+1:x[2]-8,x[3]});
            queue.add(new int[]{x[0],x[1]+1,x[2],(x[1]+1)%10!=0?x[3]+1:x[3]-8});
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount_13().movingCount(20,20,6));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
