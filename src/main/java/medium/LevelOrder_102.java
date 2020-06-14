package medium;//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/
class LevelOrder_102 {
/*
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return res;
        }
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int level){
        if (root==null){
            return;
        }
        if (res.size()<level+1){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
*/

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        List<Integer> level;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode temp;
        queue.offer(root);
        while (!queue.isEmpty()){
            level=new ArrayList<>();
            int len=queue.size();
            for (int i=0;i<len;i++){
                temp=queue.poll();
                level.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}

/*
方法一：BFS
方法二：DFS，dfs递归的时候加入层数的参数，将每次搜索到的元素加入到当前层数的List中
 */