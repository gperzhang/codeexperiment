package algorithm.multiply.june14;

import algorithm.program.reconstructbintree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 从上到下打印一个二叉树的每一个节点，同层的从左到右
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode pop = deque.pop();
            if(pop.left!=null)deque.add(pop.left);
            if(pop.right!=null)deque.add(pop.right);
            list.add(pop.val);
        }
        return list;
    }
}
