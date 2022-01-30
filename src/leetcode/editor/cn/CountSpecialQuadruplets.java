package leetcode.editor.cn;

//给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ： 
//
// 
// nums[a] + nums[b] + nums[c] == nums[d] ，且 
// a < b < c < d 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,6]
//输出：1
//解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,4,5]
//输出：0
//解释：[3,3,6,4,5] 中不存在满足要求的四元组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,1,3,5]
//输出：4
//解释：满足要求的 4 个四元组如下：
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 50 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 枚举 👍 102 👎 0

import java.util.*;

public class CountSpecialQuadruplets{
    public static void main(String[] args) {
        Solution solution = new CountSpecialQuadruplets().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countQuadruplets(int[] nums) {
//        int[]dp=new int[nums.length+1];
//        if(nums[0]+nums[1]+nums[2]==nums[3])dp[3]=1;
//        for(int i=4;i<nums.length;++i){
//
//        }
//        return dp[nums.length];

        //朴素算法，四重循环枚举
//        int ans=0;
//        for(int i=3;i<nums.length;++i)
//            for(int j=0;j<i;++j)
//                for(int p=0;p<j;++p)
//                    for(int q=0;q<p;++q){
//                        if(nums[q]+nums[p]+nums[j]==nums[i])++ans;
//                    }
//        return ans;

        //哈希表优化一重循环
        Map<Integer, List<Integer>> map=new IdentityHashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;++i){
            if(!map.containsKey(nums[i])){
                List<Integer>arr=new ArrayList<>();
                arr.add(i);
                map.put(nums[i],arr);
            }
            else{
                map.get(nums[i]).add(i);
            }
        }
        for(int c=2;c<nums.length;++c)
            for(int b=1;b<c;++b)
                for(int a=0;a<b;++a){
                    if(map.containsKey(nums[a]+nums[b]+nums[c])){
                        for(Integer v:map.get(nums[a]+nums[b]+nums[c])){
                            if(v>c){
                                ++ans;
                            }
                        }
                    }
                }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}