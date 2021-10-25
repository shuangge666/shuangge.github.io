package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 471 👎 0

import java.util.HashMap;
import java.util.Map;

public class PermutationInString{
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean ans=false;
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();++i){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
        }
        char[]arr=s2.toCharArray();
        int left=0,right=0;
        for(;right<s2.length();++right){
            while(right<arr.length&&(right-left+1)<s1.length()){
                map2.put(arr[right],map2.getOrDefault(arr[right],0)+1);
                ++right;
            }
            if(right<s2.length()){
                map2.put(arr[right],map2.getOrDefault(arr[right],0)+1);
                if(map2.equals(map1)){
                    return true;
                }
                if(map2.get(arr[left])==1)
                    map2.remove(arr[left]);
                else
                    map2.put(arr[left],map2.get(arr[left])-1);
                ++left;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}