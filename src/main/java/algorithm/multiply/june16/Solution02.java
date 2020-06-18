package algorithm.multiply.june16;

import algorithm.program.reconstructbintree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度遍历二叉树
 */
public class Solution02 {

    public ArrayList<Integer> BFS(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes!=null){
            TreeNode treeNode = nodes.poll();
            if(treeNode.left != null){
                nodes.add(root.left);
            }
            if(treeNode.right!=null){
                nodes.add(root.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}
