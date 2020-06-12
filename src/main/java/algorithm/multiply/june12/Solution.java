package algorithm.multiply.june12;

/**
 * 输入两颗树A,B判断 B是不是A的子结构，（空树不是任意树的子结构）
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
       if(root1 ==null || root2 ==null) return false;
       boolean result = false;
       if(root1.val==root2.val){
           result = doesTree1HasTree2(root1, root2);
       }
       if(!result){
           result = doesTree1HasTree2(root1.left,root2);
       }
       if(!result){
           result = doesTree1HasTree2(root1.right,root2);
       }
        return result;
    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if(root2==null)return true;
        if(root1==null)return false;
        if(root1.val!=root2.val)return false;
        return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right,root2.right);
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

