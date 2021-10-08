package leetcode.editor.cn;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 207 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindBottomLeftTreeValue{
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        
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
    public int ans=0;
    public List<List<TreeNode>>ansList;
    public int findBottomLeftValue(TreeNode root) {
        this.ansList=new ArrayList<>();
        bfs(root);
        return this.ansList.get(this.ansList.size()-1).get(0).val;
    }
    public void bfs(TreeNode root){
        if(root==null)
            return;
        LinkedList<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int deep=0;
        int len=0;
        while(!queue.isEmpty()){
            len=queue.size();
            ++deep;
            List<TreeNode>kk=new ArrayList<>();
            for(int i=1;i<=len;++i){
                TreeNode rt=queue.pollFirst();
                kk.add(rt);
                if(rt.left!=null)
                    queue.add(rt.left);
                if(rt.right!=null)
                    queue.add(rt.right);
            }
            this.ansList.add(kk);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}