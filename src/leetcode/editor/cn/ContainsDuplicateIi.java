package leetcode.editor.cn;

//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 滑动窗口 👍 326 👎 0

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left=0,right=0;
        boolean ans=false;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=1;i<=k-1;++i){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            ++right;
        }
        ++right;
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            for(Map.Entry<Integer,Integer>entry:map.entrySet()){
                if(map.get(entry.getKey())>1){
                    ans=true;
                    break;
                }
            }
            ++left;
            ++right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}