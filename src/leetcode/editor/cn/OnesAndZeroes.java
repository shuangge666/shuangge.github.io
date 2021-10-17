package leetcode.editor.cn;

//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//
//
//
// 示例 1：
//
//
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于
//n 的值 3 。
//
//
// 示例 2：
//
//
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
//
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] 仅由 '0' 和 '1' 组成
// 1 <= m, n <= 100
//
// Related Topics 数组 字符串 动态规划
// 👍 565 👎 0

public class OnesAndZeroes{
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //这道题是两个维度的01背包问题，因为既要求0的个数不超过m，有要求1的个数不超过n，即0的背包的大小为m，1的背包的大小为n
        //要使用状态压缩，不然就是三维数组，空间复杂度就比较高了
        //题目求的是最大子集的长度，所以是最值问题，最值0-1背包
        //dp[i][j][k]:strs中前i个字符串中0的累计和不超过j且1的累计和不超过k的最大子集的长度
        //dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-getZeroNum(strs[i])][k-strs[i].length+getZeroNum(strs[i])]+1)
        //滚动数组：dp[j][k]=Math.max(dp[j][k],dp[j-strs[i]中0的个数][k-strs[i]中1的个数]+1)
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<strs.length;++i){
            int zero=getZeroNum(strs[i]);
            for(int j=m;j>=zero;--j){
                for(int k=n;k>=strs[i].length()-zero;--k){
                    dp[j][k]=Math.max(dp[j][k],dp[j-zero][k-strs[i].length()+zero]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int getZeroNum(String str){
        int ans=0;
        for(char c:str.toCharArray()){
            if(c=='0')++ans;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
