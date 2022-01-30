package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7408 👎 0

public class AddTwoNumbers{
    public static void main(String[] args) {
//        Solution solution = new AddTwoNumbers().new Solution();
        System.out.println(89);
    }}

//leetcode submit region begin(Prohibit modification and deletion)
/*
 * Definition for singly-linked list.
 * /

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode ans=new ListNode();
////        ans.val=(l1.val+l2.val)%10;
////        int jinwei=(l1.val+l2.val)/10;
////        ListNode index1=l1.next;
////        ListNode index2=l2.next;
////        ListNode index=ans;
////        while(index1!=null&&index2!=null){
////            ListNode tmp=new ListNode((index1.val+index2.val+jinwei)%10);
////            jinwei=(index1.val+index2.val+jinwei)/10;
////            index.next=tmp;
////            index=tmp;
////            index1=index1.next;
////            index2=index2.next;
////        }
////        if(index1!=null&&index2==null){
////            while(index1!=null){
////                ListNode tmp=new ListNode((index1.val+jinwei)%10);
////                jinwei=(index1.val+jinwei)/10;
////                index.next=tmp;
////                index=tmp;
////                index1=index1.next;
////            }
////        }
////        else if(index1==null&&index2!=null){
////            while(index2!=null){
////                ListNode tmp=new ListNode((index2.val+jinwei)%10);
////                jinwei=(index2.val+jinwei)/10;
////                index.next=tmp;
////                index=tmp;
////                index2=index2.next;
////            }
////        }
////        if(jinwei==1){
////            ListNode mm=new ListNode(jinwei);
////            index.next=mm;
////        }
//        return ans;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}