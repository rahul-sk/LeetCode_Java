/**
 *Consider all the leaves of a binary tree, from left to right order, the values of 
 *those leaves form a leaf value sequence. For example, in the given tree above, the 
 *leaf value sequence is (6, 7, 4, 9, 8). Two binary trees are considered leaf-similar 
 *if their leaf value sequence is the same. Return true if and only if the two given trees 
 *with head nodes root1 and root2 are leaf-similar.
 * @author Rahul S Koimattur
 * Intuition : Traverse the tree in a preorder fashion and store all the leaves of the trees in 2
 *             seperate ArrayLists. finally check if the contents of two arraylists are same or not.
 */

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        dfs(root1,ans1);
        dfs(root2,ans2);
        if(ans1.size()!=ans2.size()) return false;
        for(int i=0;i<ans1.size();i++){
            if(ans1.get(i)!=ans2.get(i)){
               return false;
            }
        }
        return true;
        
    }
    private void dfs(TreeNode cur,List<Integer> arr){
         if(cur==null) return;
        if(cur.left==null && cur.right==null){
          arr.add(cur.val);
        }
        dfs(cur.left,arr);
        dfs(cur.right,arr);
    }
}