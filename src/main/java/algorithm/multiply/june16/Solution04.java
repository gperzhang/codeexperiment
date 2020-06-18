package algorithm.multiply.june16;

import algorithm.program.reconstructbintree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 先序遍历，非递归方式
 */
public class Solution04 {



    public  ArrayList<Integer> noRecursionDfs(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack!=null){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
}
