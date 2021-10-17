package leetcode.editor.cn;

//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//
// 题目数据保证答案符合 32 位整数范围。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
//
//
// 示例 2：
//
//
//输入：nums = [9], target = 3
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 1000
// nums 中的所有元素 互不相同
// 1 <= target <= 1000
//
//
//
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
// Related Topics 数组 动态规划
// 👍 505 👎 0

public class CombinationSumIv{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int combinationSum4(int[] nums, int target) {
        //本题由于顺序不同，会看做不同的组合，所以本题求的是排列问题。而兑换硬币2(CoingChange2与硬币的顺序无关，只与硬币的
        // 组合有关，所以CoinChange2是直接使用外层循环是物品，内层循环是target，然后dp[j]+=dp[j-coins[i]])
        //求组合：外层遍历物品，内层遍历背包(容量)
        //求排列:外层遍历背包(容量)，内层遍历物品
        int[]dp=new int[target+1];
        dp[0]=1;
        for(int j=0;j<=target;++j){
            for(int i=0;i<nums.length;++i){
                if(j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
