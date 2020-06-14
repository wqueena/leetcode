//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
package medium;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:queena
 * @Date:2020/5/130939
 * @Description:
 */
public class BuildTree_106 {
    List<Integer> in=new ArrayList<>();
    Stack<Integer> post=new Stack<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0;i<inorder.length;i++){
            post.push(postorder[i]);
            in.add(inorder[i]);
        }

        return help(0,in.size()-1);
    }
    public TreeNode help(int low,int up){
        if (low>up){
            return null;
        }
        int val=post.pop();
        TreeNode root=new TreeNode(val);
        root.right=help(in.indexOf(val)+1,up);
        root.left=help(low,in.indexOf(val)-1);
        return root;
    }

    public static void main(String[] args) {
        BuildTree_106 buildTree_106=new BuildTree_106();
        buildTree_106.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }

}
