package leetcode.editor.cn;

//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
//
// 示例 1:
//
//
//输入:
//
//           1
//         /   \
//        3     2
//       / \     \
//      5   3     9
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
//
//
// 示例 2:
//
//
//输入:
//
//          1
//         /
//        3
//       / \
//      5   3
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
//
//
// 示例 3:
//
//
//输入:
//
//          1
//         / \
//        3   2
//       /
//      5
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
//
//
// 示例 4:
//
//
//输入:
//
//          1
//         / \
//        3   2
//       /     \
//      5       9
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
//
//
// 注意: 答案在32位有符号整数的表示范围内。
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 257 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
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
    public int widthOfBinaryTree(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root){
        LinkedList<TreeNode> queue=new LinkedList<>();
        int maxWidth=0;
        root.val=1;
        queue.offer(root);
        int num=0;//num代表每一层的节点个数
        int gap=0;
        while(queue.size()>0){
            num=queue.size();//本层节点个数（重点！！！！！！！！！！！！）
            gap=queue.getLast().val-queue.getFirst().val+1;//本层间距
            maxWidth=Math.max(gap,maxWidth);
            for(int i=1;i<=num;++i){//遍历本层所有节点
                TreeNode node=queue.poll();//一定要poll去除队首元素，这样上面的queue.size()才是每一层元素的个数
                if(node.left!=null){
                    node.left.val=2*node.val;
                    queue.add(node.left);
                }
                if(node.right!=null){
                    node.right.val=2*node.val+1;
                    queue.add(node.right);
                }
            }
        }
        return maxWidth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
