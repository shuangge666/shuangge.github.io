package leetcode.editor.cn;

//这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。 
//
// 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。 
//
// 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：d = 1, f = 6, target = 3
//输出：1
// 
//
// 示例 2： 
//
// 输入：d = 2, f = 6, target = 7
//输出：6
// 
//
// 示例 3： 
//
// 输入：d = 2, f = 5, target = 10
//输出：1
// 
//
// 示例 4： 
//
// 输入：d = 1, f = 2, target = 3
//输出：0
// 
//
// 示例 5： 
//
// 输入：d = 30, f = 30, target = 500
//输出：222616187 
//
// 
//
// 提示： 
//
// 
// 1 <= d, f <= 30 
// 1 <= target <= 1000 
// 
// Related Topics 动态规划 👍 119 👎 0

public class NumberOfDiceRollsWithTargetSum{
    public static void main(String[] args) {
        Solution solution = new NumberOfDiceRollsWithTargetSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int ans=0;
        int mod=(int)(1e9+7);
        int[]dp=new int[target+1];//dp[i][j]代表前i个组中，获得点数和为j的方案数,则dp[i][j]=dp[i-1][j-1]+dp[i-1][j-2]+dp[i-1][j-3]+...+dp[i-1][j-k]
        dp[0]=1;
        for(int i=0;i<n;++i)
            for(int j=target;j>=0;--j) {
                dp[j]=0;//这一行清零，因为此时dp[i]的值是i-1行的dp,即dp[i-1]，但是dp[i]是等于第i行的那些数之和
                for (int m = 1; m <= Math.min(k, j); ++m) {
                    dp[j] = (dp[j] % mod + dp[j - m] % mod) % mod;
                }
            }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}