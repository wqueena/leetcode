package easy;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

class MinDepth_111 {
/*
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int level){
        if (root==null){
            return level;
        }
        if (root.left==null){
            return dfs(root.right,level+1);
        }
        if (root.right==null){
            return dfs(root.left,level+1);
        }
        int left=dfs(root.left,level+1);
        int right=dfs(root.right,level+1);
        return Math.min(left,right);
    }
*/
/*
    int min=Integer.MAX_VALUE;
    public int dfs(TreeNode root,int level){
        if (root==null){
            return level;
        }
        if (root.left==null&&root.right==null){
            min=Math.min(min,level+1);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        return min;
    }
*/
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode node;
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            int len=queue.size();
            res+=1;
            for (int i=0;i<len;i++){
                node=queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (node.left==null&&node.right==null){
                    return res;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}

/*
方法一：DFS需要判断节点的左右节点是否为空的情况，否则[1,2]会返回1，[1,2,3,4,#,#,5]会返回2
另一种写法是记录每次遍历到叶子节点时的层次最小值。
方法二：这题也可以用BFS来做，但速度慢很多
 */