package algorithm.multiply.june18;

import algorithm.program.reconstructbintree.TreeNode;

/**
 * 递归版本实现
 */
public class Solution01 {
    TreeNode head = null;
    TreeNode cur = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        Dfs(pRootOfTree);
        return head;
    }

    private void Dfs(TreeNode pRootOfTree) {
        if(pRootOfTree ==null)return;
        Dfs(pRootOfTree.left);
        if(head==null){
            head = pRootOfTree;
            cur = pRootOfTree;
        }else {
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
            cur = pRootOfTree;
        }
        Dfs(pRootOfTree.right);
    }
}
