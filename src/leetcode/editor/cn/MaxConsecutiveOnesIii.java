package leetcode.editor.cn;

//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 334 👎 0

public class MaxConsecutiveOnesIii{
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxCnt=0;
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;++right){
            if(nums[right]==1)++maxCnt;
            while(right-left+1>maxCnt+k){
                if(nums[left]==1)--maxCnt;
                ++left;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}