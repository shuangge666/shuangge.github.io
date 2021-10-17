package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//
//
// 示例 2：
//
//
//输入：nums = [1], target = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000
//
// Related Topics 数组 动态规划 回溯
// 👍 923 👎 0

public class TargetSum{
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //背包容量：target
        //物品：nums数组中的每个元素，且每个物品的价值和重量都等于他的值
        //这是0-1背包，应为每个数组元素前面的运算符只有+或者-
        int sum=0;
        for(int v:nums){
            sum+=v;
        }
        if((((sum-target)&1)==1)||(sum-target)<0)
            return 0;
        int neg=(sum-target)/2;//问题转变成了在nums数组中找到和为neg的方案数
        int[]dp=new int[neg+1];
        dp[0]=1;
        for(int i=0;i<nums.length;++i){
            for(int j=neg;j>=nums[i];--j){
//                dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]]
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[neg];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
