package leetcode.editor.cn;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 355 👎 0

import java.util.HashMap;
import java.util.Map;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        int abcabcbb = solution.dynamicProgramming("pwwkew");
        System.out.println(abcabcbb);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //return slideWindow(s);
        return dynamicProgramming(s);
    }
    public int dynamicProgramming(String s){
        if(s.equals(""))return 0;
        if(s.length()==1)return 1;
        int[]dp=new int[s.length()];//dp[i]:以i结尾的不包含重复字符的子串的长度
        Map<Character,Integer>map=new HashMap<>();//存储[0,i]每种字符最新出现的位置
        dp[0]=1;
        map.put(s.charAt(0),0);
        for(int i=1;i<s.length();++i){
            if(map.containsKey(s.charAt(i))){//之前出现过，那么dp[i]=最新出现的位置到现在位置这一段的长度
                int index=map.get(s.charAt(i));
                dp[i]=i-index;
                map.clear();
                for(int r=index+1;r<=i;++r){
                    map.put(s.charAt(r),r);
                }
            }
            else{//未曾出现过
                dp[i]=dp[i-1]+1;
                map.put(s.charAt(i),i);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();++i){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int slideWindow(String s){//滑动窗口，思路简单直观
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        char[]arr=s.toCharArray();
        while(right<arr.length){
            if(!map.containsKey(arr[right])){
                map.put(arr[right],1);
            }
            else{
                while(map.containsKey(arr[right])){
                    map.remove(arr[left]);
                    ++left;
                }
                map.put(arr[right],1);
            }
            ans=Math.max(ans,right-left+1);
            ++right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}