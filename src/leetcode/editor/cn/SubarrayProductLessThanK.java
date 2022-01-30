package leetcode.editor.cn;

//给定一个正整数数组 nums和整数 k 。 
//
// 请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 330 👎 0

public class SubarrayProductLessThanK{
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        int left=0,right=0;
        int acc=1;
        while(right<nums.length){
            if(nums[right]<k){
                ++ans;
                acc*=nums[right];
                while(acc>=k){
                    acc/=nums[left];
                    ++left;
                }
                ans+=(right-left);
            }
            else{
                left=right+1;
                acc=1;
            }
            ++right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}