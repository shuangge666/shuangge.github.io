package leetcode.editor.cn;

//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 561 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[]map=new int[26];
    public int longestSubstring(String s, int k) {
        int ans=dfs(s,k,0,s.length()-1);
        return ans;
    }
    //递归写法，如果一段字符串中某个字符的出现次数小于k，那么这个整段字符串中包含该字符的串都不是目标子串，
    //所以以该字符对原整串进行split，然后对得到的String数组中的每个串递归出来，维护ans取最大值即可；如果
    //每个字符出现次数都大于等于k，说明这段字符串符合要求，所以直接返回right-left+1即可。
    public int dfs(String s,int k,int left,int right){
        if(s.length()<k)
            return 0;
        if(left>right){
            return 0;
        }
        if(s.length()==0)
            return 0;
        Map<Character,Integer>map=new HashMap<>();
        for(int i=left;i<=right;++i){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        char goal=' ';
        int ans=0;
        int idx=0;
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            if(entry.getValue()<k){
                goal=entry.getKey();
                break;
            }
            ++idx;
        }
        if(idx==map.size())
            return right-left+1;
        String[]subStrs=s.split(String.valueOf(goal));
        for(String str:subStrs){
            ans=Math.max(ans,dfs(str,k,0,str.length()-1));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}