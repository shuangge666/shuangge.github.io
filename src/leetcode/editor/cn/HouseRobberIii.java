package leetcode.editor.cn;

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
// 示例 1:
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//输出: 7
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
//
// 示例 2:
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
//
// Related Topics 树 深度优先搜索 动态规划 二叉树
// 👍 1002 👎 0

import java.util.*;

public class HouseRobberIii{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();

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
    public List<Integer> list=new ArrayList<>();
    public Map<TreeNode,Integer>map=new HashMap<>();
    public int rob(TreeNode root) {
        int res=dfs(root);
        return res;
    }
    //这种思路对于这道题而言是错误的，因为题目只说了父子不能同时偷盗，那么和父同一层的其他节点可以和子同时偷盗
    public void bfs(TreeNode root){
        LinkedList<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int width=queue.size();//本层元素个数
            int sum=0;
            for(int i=0;i<width;++i){
                TreeNode rt=queue.poll();
                sum+=rt.val;
                if(rt.left!=null)
                    queue.add(rt.left);
                if(rt.right!=null)
                    queue.add(rt.right);
            }
            this.list.add(sum);
        }
    }

    //记忆化搜索
    //使用一个哈希表记录已经计算过的节点，如果再次遍历到该节点，就直接返回
    //对于一个根节点，他能偷的只有两种情况：
    //(1)根节点的值+左子树的(左子树和右子树)+右子树的(左子树和右子树)
    //(2)根节点的左右子树和
    public int dfs(TreeNode rt){
        if(rt==null)
            return 0;
        if(map.containsKey(rt)){
            return map.get(rt);
        }
        int sum=rt.val;
        if(rt.left!=null){
            sum+=dfs(rt.left.left);
            sum+=dfs(rt.left.right);
        }
        if(rt.right!=null){
            sum+=dfs(rt.right.left);
            sum+=dfs(rt.right.right);
        }
        int res= Math.max(sum,dfs(rt.left)+dfs(rt.right));
        map.put(rt,res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
