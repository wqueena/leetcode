package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:queena
 * @Date:2020/5/122112
 * @Description:
 */
public class Traverse {
    List<Integer> pre=new ArrayList<>();
    List<Integer> in=new ArrayList<>();
    List<Integer> post=new ArrayList<>();

    public void preOrder(TreeNode root){
        if (root!=null){
            pre.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root){
        if (root!=null){
            inOrder(root.left);
            in.add(root.val);
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root){
        if (root!=null){
            postOrder(root.left);
            postOrder(root.right);
            post.add(root.val);
        }
    }

}
