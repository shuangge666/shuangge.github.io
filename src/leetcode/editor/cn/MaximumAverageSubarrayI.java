package leetcode.editor.cn;

//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。 
//
// 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 
//
// 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 示例 2： 
//
// 
//输入：nums = [5], k = 1
//输出：5.00000
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 滑动窗口 👍 204 👎 0

public class MaximumAverageSubarrayI{
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //滑动窗口解法
        int sum=0;
        int ans=0;
        int left=0,right=0;

        while(right<k){
            sum+=nums[right];
            ++right;
        }
        ans=sum;
        while(right<nums.length){
            sum+=nums[right];
            sum-=nums[left];
            ans=Math.max(ans,sum);
            ++left;
            ++right;
        }
        return (double)ans/k;

    }

    //前缀和解法
    public double preSum(int[]nums,int k){
        int[]pre=new int[nums.length+1];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;++i){
            pre[i]=pre[i-1]+nums[i];
        }
        int left=1,right=k;
        double ans=(double)pre[k-1]/k;
        while(right<nums.length){
            ans=Math.max(ans,(double)(pre[right]-pre[left-1])/k);
            ++left;
            ++right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}