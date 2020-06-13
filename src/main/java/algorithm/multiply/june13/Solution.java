package algorithm.multiply.june13;

import algorithm.program.reconstructbintree.TreeNode;

public class Solution {
    public void Mirror(TreeNode root) {
        if(root!=null ){
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            Mirror(root.left);
            Mirror(root.right);
        }

    }

}
