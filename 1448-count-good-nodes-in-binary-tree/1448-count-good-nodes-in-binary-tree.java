/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int dfs(TreeNode root,int valu){
        if(root==null) return 0;
        int count=0;
        if(root.val >= valu){
            count++;
        }
        
        valu=Math.max(valu,root.val);
        count+=dfs(root.left,valu);
        count+=dfs(root.right,valu);
        return count;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
}