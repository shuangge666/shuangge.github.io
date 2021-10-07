package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 780 👎 0

public class BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

 // Definition for a binary tree node.
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

  /*平衡二叉树满足任意节点的左右子树高度差不大于1，“任意节点”就注定了要使用递归来求解，
  只需要记录所有每个节点的左右子树的高度差的最大值，最后根据这个高度差最大值是否大于1就可得到答案，
  还是一样，Java函数传参都是值传递，所以用一个只有一个元素的数组a作为参数，a[0]维护着最大高度差
  *
  * */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int[]a=new int[1];
        getDep(root,1,a);
        return (a[0]<=1)?true:false;
    }
    public int getDep(TreeNode root,int dep,int[]a){
        if(root==null)return 0;
        int leftDep=getDep(root.left,dep+1,a);
        int rightDep=getDep(root.right,dep+1,a);
        a[0]=Math.max(a[0],Math.abs(leftDep-rightDep));
        return Math.max(leftDep,rightDep)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
