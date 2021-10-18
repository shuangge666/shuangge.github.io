package leetcode.editor.cn;

//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//
//
// 示例：
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
//
//
//
//
// 提示：
//
//
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希
// 👍 554 👎 0

public class MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //最长公共子序列的dp[i][j]含义：nusm1前i个元素和nums2前j个元素的最长公共子数组的长度
        //最长重复子数组dp[i][j]含义：以nums1[i-1]结尾的子数组和以nums2[j-1]结尾的子数组的最长公共子数组的长度
        //对比：最长公共子序列求得的"序列"De最大长度，序列在原数组中不一定是连续的，所以等价于是离散的，所以
        //递推公式中直接比较text1[i-1]和text2[j-1]是否相等，如果相等当然是dp[i-1][j-1]+1,如果不等，由于是离散的
        //,所以dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //而最长重复子数组中，要求的是子数组，这段子数组是连续的，这种情况dp[i][j]的含义就是以nums1[i-1]结尾且以
        //nums2[j-1]结尾的最长重复子数组的长度。如果nums1[i-1]和nums2[j-1]相等，当然dp[i][j]=dp[i-1][j-1]+1;
        //但是如果不等，那么说明不存在既以nums1[i-1]结尾有以nums2[j-1]结尾的最长重复子数组，所以dp[i][j]=0,并且由于求得的
        //最长的重复子数组长度，所以要维护一个变量ans，在递推过程中不断更新ans，使得ans取得的是最大值，最后返回ans即可。
        int[][]dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        for(int i=1;i<= nums1.length;++i){
            for(int j=1;j<=nums2.length;++j){
                if(nums1[i-1]==nums2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else{
                    dp[i][j]=0;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
