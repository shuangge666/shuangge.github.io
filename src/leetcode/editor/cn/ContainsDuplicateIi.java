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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean ans=false;
        int left=0,right=0;
        Set<Integer> set=new HashSet<>();
        while(right<Math.min(k,nums.length)){//一定要注意循环结束后right的指向啊！！！
            set.add(nums[right]);
            ++right;
        }
        --right;//循环结束后，如果k<nums.length,那么right此时是指向nums[k]的，但是set中只有nums[0,k-1]
        if(k>=nums.length){
            if(set.size()==nums.length)
                return false;
            else
                return true;
        }
        while(right<nums.length){
            ++right;
            if(right==nums.length){
                break;
            }
            set.add(nums[right]);
            if(set.size()<right-left+1){
                ans=true;
                break;
            }
            else{
                set.remove(nums[left]);
                ++left;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}