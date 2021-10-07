package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 104] 内
// -231 <= Node.val <= 231 - 1
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 1237 👎 0

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

 //Definition for a binary tree node.
  public class TreeNode {
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
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        pre=null;
        return dfs(root);
    }
    public boolean dfs(TreeNode root){
        if(root==null)
            return true;
        boolean ansLeft=dfs(root.left);
        if(pre==null)
            pre=root;
        else if(pre.val>=root.val)
            return false;
        pre=root;
        boolean ansRight=dfs(root.right);
        return ansLeft&&ansRight;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
