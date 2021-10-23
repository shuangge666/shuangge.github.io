package leetcode.editor.cn;

//给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 示例 4： 
//
// 输入：nums = [1,1,0,0,1,1,1,0,1]
//输出：4
// 
//
// 示例 5： 
//
// 输入：nums = [0,0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// nums[i] 要么是 0 要么是 1 。 
// 
// Related Topics 数学 动态规划 滑动窗口 👍 41 👎 0

public class LongestSubarrayOf1sAfterDeletingOneElement{
    public static void main(String[] args) {
        Solution solution = new LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {

//        设置一个剩余可删除次数rest，初始设置为1
//
//        窗口右边界向右滑动过程中，遇到0，则删除（rest--），直至扩到遇到0但不能再删为止（nums[r]==0 && rest<0）
//
//        结算窗口内有效长度，窗口长度 = r - l，但是有效长度 = r - l -1，因为窗口内有一个0，是要删除的，所以要减1
//
//        然后窗口左边界开始向右滑动，元素出窗口，如果元素是0，则rest++，直到又有可删次数（rest>0）停止
            int n = nums.length;
            int ans = 0;
            int l = 0, r = 0; // 滑动窗口左右边界
            int rest = 1; // 剩余删除次数
            while (r < n) {
                // r向右滑动，遇1继续，遇0且尚有删除次数（rest>0），则删除（rest--），
                // 直到遇0且不能删为止（nums[r]==0 && rest<0），或者到终止位置为止
                while (r < n) {
                    if (nums[r] == 0 && rest == 0) break; // 遇0，却不能删了
                    if (nums[r] == 0) rest--; // 遇0，但可删
                    r++;
                }
                // 此时，窗口[l ... r)长度为：r-l，但是其中有一个0，是要删除的，所以，有效长度：r-l-1
                ans = Math.max(ans, r - l - 1);
                // 窗口左边界开始向右滑动，元素出窗口，如果元素是0，则rest++，直到又有可删次数（rest>0）停止
                while (l < r && rest == 0) {
                    if (nums[l] == 0) rest++;
                    l++;
                }
            }
            return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}