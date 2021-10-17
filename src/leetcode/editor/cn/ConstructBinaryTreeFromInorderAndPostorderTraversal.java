package leetcode.editor.cn;

//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 592 👎 0

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root=null;
        root=dfs(root,inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        return root;
    }
    public TreeNode dfs(TreeNode root ,int[]inorder,int[]postorder,int inleft,int inright,int poleft,int poright){
        /*后序遍历的最后一个数是根节点，根据这个值去中序遍历序列中找到相应位置，以该位置
        为分割线将中序遍历序列分割成了左子树和右子树，再在后续遍历里面找到相应的分界点，
        然后再递归下去即可。需要传入四个位置参数，分别是inorder的left和right,
        postorder的left和right
        再中序遍历的pos处也就是后序遍历右子树根节点的位置
        * */
        //注意边界条件，我是采用左闭右闭的区间方式，所以递归终止条件是left>right,这个时候返回null即可。
        if(inleft>inright)
            return null;
        int rootVal=postorder[poright];
        int pos=inleft;
        for(int i=inleft;i<=inright;++i){
            if(inorder[i]==rootVal){
                pos=i;
                break;
            }
        }
        root=new TreeNode(rootVal);
        root.left=dfs(root.left,inorder,postorder,inleft,pos-1,poleft,poleft-inleft+pos-1);
        root.right=dfs(root.right,inorder,postorder,pos+1,inright,pos+poleft-inleft,poright-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}