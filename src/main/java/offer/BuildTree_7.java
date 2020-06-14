package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:queena
 * @Date:2020/5/281048
 * @Description:
 */
public class BuildTree_7 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    List<Integer> inlist=new ArrayList<>();
    for (int i:inorder){
      inlist.add(i);
    }
    return help(preorder,inlist,0,inlist.size()-1,0);
  }
  public TreeNode help(int[] preorder,List<Integer> inlist,int low,int up,int i){
    if (low>up){
      return null;
    }
    TreeNode root =new TreeNode(preorder[i]);
    int index=inlist.indexOf(root.val);
    root.left=help(preorder,inlist,low,index-1,i+1);
    root.right=help(preorder,inlist,index+1,up,i+index-low+1);
    return root;
  }

}
/*
    root.right=help(preorder,inlist,index+1,up,i+index-low+1);
    这里的i+index-low+1指的是i(根节点在inlist中的位置)+index-low(左子树的长度)+1，
    也就是指当前要找的节点在inlist中的位置。

 */