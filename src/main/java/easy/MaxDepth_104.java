package easy;

/*给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
给定二叉树 [3,9,20,null,null,15,7]，

     3
   / \
  9  20
    /  \
   15   7

 返回它的最大深度 3 。
 Related Topics 树 深度优先搜索*/


//leetcode submit region begin(Prohibit modification and deletion)


public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        //一行代码即可
        //return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        if (root==null){
            return 0;
        }
        return dfs(root,0);
    }
    public int dfs(TreeNode root, int level){
        if (root==null){
            return level;
        }
        int left=dfs(root.left,level+1);
        int right=dfs(root.right,level+1);
        return Math.max(left,right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
