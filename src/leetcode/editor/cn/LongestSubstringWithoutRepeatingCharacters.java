package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6283 👎 0

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> map=new HashMap<>();
//        int left=0,right=0,cnt=0,len=0;//cnt记录窗口中字符的种类数
//        while(right<s.length()) {
//            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
//            while(map.get(s.charAt(right))>1){
//                map.put(s.charAt(left),map.get(s.charAt(left))-1);
//                ++left;
//            }
//            len=Math.max(len,(right-left+1));
//            ++right;
//        }
//        return len;
        return getAns(s);
    }

    public int getAns(String s){
        if(s.length()==0)return 0;
        Map<Character,Integer>map=new HashMap<>();
        int left=0,right=0;
        int ans=Integer.MIN_VALUE;
        for(;right<s.length();++right){
            if(map.containsKey(s.charAt(right))==false){
                map.put(s.charAt(right),1);
                ans=Math.max(ans,right-left+1);
            }
            else{
                while(left<right&&map.containsKey(s.charAt(right))){
                    map.remove(s.charAt(left));
                    ++left;
                }
                map.put(s.charAt(right),1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}