package leetcode.editor.cn;

//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 10⁴。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 494 👎 0

public class LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        //这道题是经典的滑动窗口题目，很经典，要牢牢掌握
        //这道题的滑动窗口真的是不太好理解，一定要多复习
        int ans=0;
        int left=0,right=0;
        int[]map=new int[26];
        int res=0;
        char[]nums=s.toCharArray();
        while(right<nums.length){
            int idx=nums[right]-'A';
            ++map[idx];
            ans=Math.max(ans,map[idx]);
            if(ans+k<right-left+1){
                map[nums[left]-'A']--;
                ++left;
            }
            res=Math.max(res,right-left+1);
            ++right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}