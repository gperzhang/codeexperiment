package algorithm.multiply.june16;

import algorithm.program.reconstructbintree.TreeNode;

import java.util.ArrayList;

/**
 * 输入一个二叉树 和 一个数，返回所有节点之和等于target的路径
 *
 * /深度遍历 分为  先序，中序，后序
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> foundPath(int target, TreeNode root){
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(root==null)return results;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root,path,results,target,root.val);
        return results;
    }

    private void helper(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> results, int target, int sum) {
        if(root.left==null && root.right==null){
            if(target==sum){
                results.add(new ArrayList<>(path));
            }
            return;
        }
        if(root.left!=null){
            path.add(root.left.val);
            helper(root.left,path,results,target,sum+root.left.val);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.right.val);
            helper(root.right,path,results,target,sum+root.right.val);
            path.remove(path.size()-1);
        }
    }
}
