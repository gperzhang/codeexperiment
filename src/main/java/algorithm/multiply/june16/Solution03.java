package algorithm.multiply.june16;

import algorithm.program.reconstructbintree.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的深度遍历
 * 先序 递归方式
 */
public class Solution03 {

    public ArrayList<Integer> Dfs(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)return list;
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root, ArrayList<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
}
