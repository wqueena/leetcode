package medium;

import java.util.Stack;

/**
 * @Author:queena
 * @Date:2020/5/121004
 * @Description:
 */
public class IsValidBST {
/*    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        Double left=findMax(root.left,Double.NEGATIVE_INFINITY);
        Double right=findMin(root.right,Double.POSITIVE_INFINITY);
        System.out.println(left+" "+right);
        if (left>=right||left>=root.val||root.val>=right){
            return false;
        }
        return isValidBST(root.left)&&isValidBST(root.right);
    }

    public Double findMin(TreeNode root,Double min){
        if (root==null){
            return min;
        }
        min=Math.min(min,findMin(root.left,new Double(root.val)));
        min=Math.min(min,findMin(root.right,new Double(root.val)));
        return min;
    }
    public Double findMax(TreeNode root,Double max){
        if (root==null){
            return max;
        }
        max=Math.max(max,findMax(root.left,new Double(root.val)));
        max=Math.max(max,findMax(root.right,new Double(root.val)));
        return max;
    }*/

    /*public boolean isValidBST(TreeNode root) {
        return help(root,null,null);
    }
    public boolean help(TreeNode root,Integer low,Integer up){
        if (root==null){
            return true;
        }
        if (low!=null&&root.val<=low){
            return false;
        }
        if (up!=null&&root.val>=up){
            return false;
        }
        return help(root.left,low,root.val)&&help(root.right,root.val,up);
    }*/
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null,cur=null;
        while (!stack.isEmpty()||root!=null){
            if (root!=null){
                stack.push(root);
                root=root.left;
                continue;
            }
            cur=stack.pop();
            if (prev!=null&&prev.val>=cur.val){
                return false;
            }
            prev=cur;
            root=cur.right;
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(3);
        treeNode.right.right=new TreeNode(6);
        IsValidBST isValidBST=new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
     }
}

/*
方法一：用递归的方法找左子树的最大值left和右子树的最小值right，
当left>=right或者left>=root或者root>=right的时候返回假
方法二：用递归的方法，传入上下界限，每次判断当前节点的值是否符合上下界限，
如果不符合，直接返回假（最优）
方法三：用中序遍历的方法，保存一个上继节点和当前节点，
如果上继节点的值大于等于当前节点的值，直接返回假
 */