package leetcode.editor.cn;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 369 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]ans;
        if(nums.length==0)return nums;
        if(nums.length==1)return nums;
        ans=new int[nums.length-k+1];
        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return -o1+o2;
            }
        });
        int left=0,right=k-1;
        for(;right<nums.length;++left,++right){
            if(left==0){
                for(int p=left;p<=right;++p){
                    queue.add(nums[p]);
                }
                ans[0]=queue.peek();
                queue.remove((Object)nums[left]);
            }
            else{
                queue.add(nums[right]);
                ans[left]=queue.peek();
                queue.remove((Object)nums[left]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}