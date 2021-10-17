package leetcode.editor.cn;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9
//
//
// 提示：
//
//
// 1 <= n <= 104
//
// Related Topics 广度优先搜索 数学 动态规划
// 👍 1112 👎 0

import java.util.Arrays;

public class PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        //首先，明确是完全背包问题，应为每个数可以选择多次
        //dp数组含义：装满容量为j的背包的最少数量
        //然后确定物品种类数：肯定小于等于n开根号
        //确定每个物品重量：第i个物品重量当然是i*i
        //确定物品价值：选择这个物品，那么数量+1
        int num=(int)Math.sqrt(n);//物品种类个数：num个，背包容量：n,第i个物品价值：i*i
        int[]dp=new int[1+n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        for(int i=1;i<=num;++i){
            for(int j=i*i;j<=n;++j){
                if(dp[j-i*i]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
