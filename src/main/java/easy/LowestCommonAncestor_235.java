package easy;

import java.util.TreeMap;

/**
 * @Author:queena
 * @Date:2020/5/121648
 * @Description:
 */
public class LowestCommonAncestor_235 {
/*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode p1=p.val<q.val?p:q;
        TreeNode q1=p.val>q.val?p:q;
        if (root.val>p1.val&&root.val<q1.val){
            return root;
        }
        else if (root.val>q1.val){
            lowestCommonAncestor(root.left,p1,q1);
        }
        else if (root.val<p1.val){
            lowestCommonAncestor(root.right,p1,q1);
        }
        return root;
    }
*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if (root.val>p.val&&root.val>q.val){
                root=root.left;
                continue;
            }
            if (root.val<p.val&&root.val<q.val){
                root=root.right;
                continue;
            }
            return root;
        }
        return root;
    }
}
/*
方法一：递归（更快）
方法二：用while循环
 */