package medium;

/**
 * @Author:queena
 * @Date:2020/5/110014
 * @Description:
 */
public class LowestCommonAncestor_236 {
/*    TreeNode res=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root==null){
            return false;
        }
        boolean left=dfs(root.left,p,q);
        boolean right=dfs(root.right,p,q);
        if (left&&right||((root==p||root==q)&&(left||right))){
            res=root;
        }
        return left||right||root==p||root==q;
    }*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findPandQ(root,p,q);
    }
    public TreeNode findPandQ(TreeNode root, TreeNode p, TreeNode q){
        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode left=findPandQ(root.left,p,q);
        TreeNode right=findPandQ(root.right,p,q);
        return left==null?right:right==null?left:root;
    }
}

/*
1.用递归的方法，分别在左右子树里判断是否存在p和q
2.同样是递归，但是思路更清晰一些，运行也会快一些，分别在左右子树里找p和q
 */
