package algorithm.program.reconstructbintree;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static final Map<Integer,Integer> hashMap = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for(int i=0;i<in.length;i++){
            hashMap.put(in[i],i);
        }
        reConstructBinaryTree(pre,0,pre.length-1,0);
        return null;
    }
    private TreeNode reConstructBinaryTree(int [] pre,int preL,int preR,int inL){
        if(preL>preR){
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer index = hashMap.get(root.val);
        int leftSize = index-inL;
        root.left = reConstructBinaryTree(pre,preL+1,leftSize+preL,inL);
        root.right = reConstructBinaryTree(pre,preL+leftSize+1,preR,inL+leftSize+1);
        return root;
    }
}
