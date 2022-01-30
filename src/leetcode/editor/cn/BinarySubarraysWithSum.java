package leetcode.editor.cn;

//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 👍 226 👎 0

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum{
    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //这种题要认真总结！不要放过这道题！！！
    public int numSubarraysWithSum(int[] nums, int t) {
        return preSum(nums,t);
    }
    public int slideWindow(int[]nums,int t){
        int n = nums.length;
        int ans = 0;
        for (int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > t) s1 -= nums[l1++];
            while (l2 <= r && s2 >= t) s2 -= nums[l2++];
            ans += l2 - l1;
        }
        return ans;
    }
    public int preSum(int[]nums,int goal){
        /*
        前缀和技巧：
            前缀和数组prefix大小开成nums.length+1,
            prefix[0]=0，prefix[1]表示nums[0]

         */
        int[]prefix=new int[nums.length+1];
        prefix[0]=0;
        for(int i=1;i<prefix.length;++i){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<prefix.length;++i){//遍历prefix时从0开始遍历
            if(map.containsKey(prefix[i])){
                ans+=map.get(prefix[i]);
            }
            map.put(prefix[i]+goal,map.getOrDefault(prefix[i]+goal,0)+1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}