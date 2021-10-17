package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics 数组 动态规划
// 👍 971 👎 0

import java.util.Arrays;

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int aaa;
    boolean dfsAns=false;
    public boolean canPartition(int[] nums) {
        boolean ans=false;
        this.aaa= Arrays.stream(nums).boxed().reduce(0,(o1,o2)->{return o1+o2;});
        if((this.aaa&1)==1)
            return false;
        int sum=this.aaa/2;//sum就是背包容量
        int[]dp=new int[sum+1];//dp[i]:容量为i的背包能装的最大价值(数值的和)
        //问题变成了对于数组中的每个元素有选或者不选，使得存在一种选法使得选出来的部分元素和等于sum
        //初始化dp数组
        dp[0]=0;
        for(int i=0;i<nums.length;++i)
            for(int j=sum;j>=nums[i];--j){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        return dp[sum]==sum;//容量为j的背包能装入的最大价值看是不是也等于j，如果等于，，说明能找到
//        dfs(0,0,nums);
//        return dfsAns;
    }
    /*dfs直接超时*/
    public void dfs(int index,int s,int[]arr){
        if(index>=arr.length)
            return;
        if(s==this.aaa/2){
            this.dfsAns=true;
            return ;
        }
        dfs(index+1,s,arr);//不选arr[index]
        dfs(index+1,s+arr[index],arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
