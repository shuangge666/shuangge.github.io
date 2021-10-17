package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
// Related Topics 数组 动态规划
// 👍 801 👎 0

import java.util.Arrays;

public class HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        int[]arr=new int[]{1,2,3,1};

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[]dp;

    public int rob(int[] nums) {
        dp=new int[nums.length+1];
//        dp[0]=0;
//        dp[1]=nums[0];
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length==3)
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int left=robOrigin(nums,1,nums.length-1);
        int right=robOrigin(nums,2,nums.length);
        int ans=Math.max(left,right);
        return ans;
    }
    public int robOrigin(int[]nums,int s,int e){
        //求解nums中[s-1,e-1]的能够获得的最大钱数
        if(s<1||e>nums.length)
            return -1;
        Arrays.fill(dp,0);
        dp[s]=nums[s-1];//dp从1开始，nums从0开始,所以dp[s]对应num[s-1]
        dp[s+1]=Math.max(nums[s-1],nums[s]);
        for(int i=s+2;i<=e;++i){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[e];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
