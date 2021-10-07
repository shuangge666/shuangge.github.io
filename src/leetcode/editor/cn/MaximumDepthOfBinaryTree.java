package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 979 👎 0

public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int maxDepth(TreeNode root) {
        int[] ans=new int[1];
        ans[0]=0;
        dfs(root,1,ans);
        return ans[0];
    }
    public void dfs(TreeNode root,int dep,int[]maxDep){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            maxDep[0]=Math.max(dep,maxDep[0]);
            return ;
        }
        maxDep[0]=Math.max(maxDep[0],dep);
        if(root.left!=null)
            dfs(root.left,dep+1,maxDep);
        if(root.right!=null)
            dfs(root.right,dep+1,maxDep);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
