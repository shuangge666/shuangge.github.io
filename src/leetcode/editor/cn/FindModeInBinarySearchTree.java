package leetcode.editor.cn;

//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
//给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 353 👎 0

import java.util.*;

public class FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();

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
        public TreeNode pre;
        public List<Integer>list;
        public int maxNum;
        public int cnt;
    public int[] findMode(TreeNode root) {
        //传统哈希表暴力算法
        /*
        Map<Integer,Integer>map=new HashMap<>();
        dfs(root,map);
        List<Map.Entry<Integer,Integer>>list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2)->{return o2.getValue()-o1.getValue();});
        List<Integer>aa=new ArrayList<>();
        int cv=list.get(0).getValue();
        int i=0;

        while(i<list.size()&&cv==list.get(i).getValue()){
            aa.add(list.get(i).getKey());
            ++i;
        }
        return aa.stream().mapToInt(Integer::intValue).toArray();
        */
        this.pre=null;
        this.list=new ArrayList<>();
        this.maxNum=0;
        this.cnt=0;
        ddfs(root);
        return this.list.stream().mapToInt(Integer::intValue).toArray();
    }
    //这是暴力解法，直接使用一个哈希表，统计每个root.val的出现频率，，没有用到二叉搜索树的特性
    public void dfs(TreeNode root, Map<Integer,Integer>map){
        if(root==null)return;
        dfs(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        dfs(root.right,map);
        return ;
    }

    //使用二叉搜索的性质的树上双指针算法
    public void ddfs(TreeNode cur){
        if(cur==null)return;
        ddfs(cur.left);
        if(pre==null){
            this.cnt=1;
            this.maxNum=1;
        }
        else{
            if(this.pre.val==cur.val)
                ++cnt;
            else{
                cnt=1;
            }

        }
        if(cnt>maxNum){
            list.clear();
            list.add(cur.val);
            maxNum=cnt;
        }
        else if(cnt==maxNum){
            list.add(cur.val);
        }

        this.pre=cur;
        ddfs(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//    public int[] findMode(TreeNode root) {
//        List<Integer>list=new ArrayList<>();
//        dfs(root,list);
//        int i=0;
//        int j=0;
//        List<Integer>ans=new ArrayList<>();
//        int maxTime=0;
//        for(;j<list.size()&&i<list.size();){
//            while(j<list.size()&&list.get(j)==list.get(i))
//                ++j;
//
//            if(maxTime<(j-i)){
//                ans.clear();
//                ans.add(list.get(i));
//                maxTime=(j-i);
//            }
//            else if(maxTime==(j-i)){
//                ans.add(list.get(i));
//            }
//            i=j;
//        }
//        int[]dd=ans.stream().mapToInt(Integer::intValue).toArray();
//        return dd;
//    }
//    public void dfs(TreeNode root, List<Integer>list){
//        if(root==null)return;
//        dfs(root.left,list);
//        list.add(root.val);
//        dfs(root.right,list);
//        return ;
//    }
}
