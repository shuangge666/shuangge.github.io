package leetcode.editor.cn;

//给定一个 N 叉树，找到其最大深度。
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
//
//
// 示例 2：
//
//
//
//
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：5
//
//
//
//
// 提示：
//
//
// 树的深度不会超过 1000 。
// 树的节点数目位于 [0, 104] 之间。
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 185 👎 0

import java.util.LinkedList;
import java.util.List;

public class MaximumDepthOfNAryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public int maxDepth(Node root) {
        int[]a=new int[1];
//        dfs(root,1,a);
        bfs(root,a);
        return a[0];
    }
    /*dfs轻松解决，毫无难度*/
    public void dfs(Node root,int dep,int[]a){
        if(root==null)
            return;
        a[0]=Math.max(a[0],dep);
        for(Node child:root.children){
            dfs(child,dep+1,a);
        }
        return;
    }
    /*使用bfs解决*/
    public void bfs(Node root,int[]a){
        if(root==null)
            return;
        LinkedList<Node>queue=new LinkedList<>();
        queue.offer(root);
        int dep=0;
        while(queue.size()>0){
            ++dep;
            a[0]=Math.max(a[0],dep);
            int size=queue.size();
            for(int i=0;i<size;++i){
                Node node=queue.poll();
                for(Node e:node.children){
                    queue.offer(e);
                }
            }
        }
        return ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
