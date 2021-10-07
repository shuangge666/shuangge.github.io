package leetcode.editor.cn;

//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
//
//
//
// 示例 1：
//
//
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
//
//
// 示例 2：
//
//
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 按 严格递增 顺序排列
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树
// 👍 853 👎 0

public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

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

    /*每次取区间中间的值作为新节点的val，递归进行下去*/
    /*应该从这道题中学习java创建节点并且执行的问题，应为java只有值传递。
    *
    * Java使用链表型节点创建树的注意点：
    * Java没有引用传递，只有值传递，所以在函数里面一定要将TreeNode对象返回，
    * 这样当前节点root的root.left和root.right才有指向
    * */
class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=null;
        root=insert(root,0,nums.length-1,nums);

        return root;
    }
    public TreeNode insert(TreeNode root,int left,int right,int[]nums){
        if(left>right)
            return null;
        int mid=(left+right)/2;
        if(root==null){
            root=new TreeNode(nums[mid]);
        }
        root.left=insert(root.left,left,mid-1,nums);
        root.right=insert(root.right,mid+1,right,nums);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
