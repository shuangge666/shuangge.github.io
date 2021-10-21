package leetcode.editor.cn;

//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 507 👎 0

import java.util.TreeSet;

public class ContainsDuplicateIii{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //这道题挺难的，解法也很值得深究

        //二分加滑动窗口
        return treeSetAndSliderWindow(nums,k,t);
    }

    //TreeSet加滑动窗口
    public boolean treeSetAndSliderWindow(int[] nums, int k, int t){
        TreeSet<Long>set=new TreeSet<>();
        int idx=0;
        while(idx<nums.length){
            Long left=set.floor(nums[idx]*1L);
            Long right=set.ceiling(nums[idx]*1L);
            if(left!=null&&left>=nums[idx]*1L-t)return true;
            if(right!=null&&right<=nums[idx]*1L+t)return true;
            set.add(nums[idx]*1L);
            if(set.size()>k)
                set.remove(nums[idx-k]*1L);

            ++idx;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}