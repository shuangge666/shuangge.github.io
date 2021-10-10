package leetcode.editor.cn;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 二叉搜索树 二叉树 👍 544 👎 0

public class DeleteNodeInABst{
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
        
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

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        root=dfs(root,key);
        return root;
    }
    public TreeNode dfs(TreeNode rt,int key){
        /*选取val为key的节点的左子树的最右边或者其右子树的最左边最为新的根节点，其实就是修改下该根节点的val，然后删除左子树的最右边
        * 或者右子树的最左边即可*/
        /*二叉搜索树最麻烦的就是删除节点，这道题还没解决，明天解决它*/
        if(rt==null)
            return null;
        if(rt.val==key){
            if(rt.left==null&&rt.right==null)
                return null;
            else if(rt.left==null&&rt.right!=null){
                return rt.right;
            }
            else if(rt.left!=null&&rt.right==null){
                return rt.left;
            }
            else if(rt.left!=null&&rt.right!=null){
                TreeNode tmp=rt.left;
                TreeNode tmpFar=rt;
                while(tmp.left!=null&&tmp.right==null)
                    tmp=tmp.left;
                if(tmp.right==null){//一条直线
                    TreeNode ptr1=rt;
                    TreeNode ptr2=rt.left;
                    if(ptr2==tmp){
                        ptr1.val=ptr2.val;
                        ptr1.left=null;
                        return rt;
                    }
                    while(ptr2!=tmp){
                        ptr1.val=ptr2.val;
                        ptr1=ptr2;
                        ptr2=ptr2.left;
                    }
                    ptr1.left=null;
                    return rt;
                }
                while (tmp.right!=null)
                {
                    tmpFar=tmp;
                    tmp=tmp.right;
                }
                rt.val=tmp.val;
                tmpFar.right=null;
                return rt;
            }

        }
        else if(rt.val>key)
            rt.left=dfs(rt.left,key);
        else
            rt.right=dfs(rt.right,key);
        return rt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}