package leetcode.editor.cn;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 👍 3848 👎 0

public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //dp数组含义:dp[i]代表以nums[i-1]结尾的子数组的最大和
        //递推公式：if(dp[i-1]<0)dp[i]=nums[i-1]  else dp[i]=dp[i-1]+nums[i-1];
        if(nums.length==1)
            return nums[0];
        int[]dp=new int[nums.length+1];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;++i){
            if(dp[i-1]<0)
                dp[i]=nums[i-1];
            else{
                dp[i]=dp[i-1]+nums[i-1];
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
