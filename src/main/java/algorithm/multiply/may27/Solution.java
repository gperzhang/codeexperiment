package algorithm.multiply.may27;

import java.util.Arrays;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

/**
 * 通过前序遍历的结果和中序遍历的结果重建这个二叉树
 */
public class Solution {

      public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
          if(pre.length==0){
              return null;
          }
          int rootVal = pre[0];
          TreeNode root = new TreeNode(pre[0]);
          int rootIndex = findRoot(in, rootVal);

          int [] leftPreOrder = Arrays.copyOfRange(pre,1,rootIndex+1);
          int [] leftMediaOrder = Arrays.copyOfRange(in,0,rootIndex);
          root.left = reConstructBinaryTree(leftPreOrder,leftMediaOrder);
          int [] rightPreOrder = Arrays.copyOfRange(pre,rootIndex+1,pre.length);
          int [] rightMedOrder = Arrays.copyOfRange(in,rootIndex+1,in.length);
          root.right = reConstructBinaryTree(rightPreOrder,rightMedOrder);

          return root;
    }

    private int findRoot(int[] in,int value) {
          int i=0;
          while(in[i]!=value && i<in.length-1){
              i++;
          }
          return i;

    }
}
