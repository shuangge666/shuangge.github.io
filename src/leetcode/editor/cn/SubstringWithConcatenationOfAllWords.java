package leetcode.editor.cn;

//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 592 👎 0

import java.util.*;

public class SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer> map1=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        int wLen=words.length;
        int wordLen=words[0].length();
        for(String str:words)map.put(str,map.getOrDefault(str,0)+1);
        int sIndex=0;
        while(sIndex<=s.length()-wLen*wordLen){
            map1.clear();
            for(int i=sIndex;i<sIndex+wLen*wordLen;i+=wordLen){
                map1.put(s.substring(i,i+wordLen),1+map1.getOrDefault(s.substring(i,i+wordLen),0));
            }
            if(cmp(map1,map)){
                ans.add(sIndex);
            }
            ++sIndex;
        }
        return ans;
//        List<Integer> ans = new ArrayList<>();
//        if (words.length == 0) return ans;
//        int n = s.length(), m = words.length, w = words[0].length();
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//        out:for (int i = 0; i + m * w <= n; i++) {
//            Map<String, Integer> cur = new HashMap<>();
//            String sub = s.substring(i, i + m * w);
//            for (int j = 0; j < sub.length(); j += w) {
//                String item = sub.substring(j, j + w);
//                if (!map.containsKey(item)) continue out;
//                cur.put(item, cur.getOrDefault(item, 0) + 1);
//            }
//            if (cmp(cur, map)) ans.add(i);
//        }
//        return ans;

    }
    boolean cmp(Map<String,Integer>m1,Map<String,Integer>m2){
        if(m1.size()!=m2.size())
            return false;
        Set<String> ketSet=m1.keySet();
        boolean ans=true;
        for(String str:m1.keySet()){
            if(!m2.containsKey(str)||!m1.get(str).equals(m2.get(str))){
                ans=false;
                break;
            }
        }
        for(String str:m2.keySet()){
            if(!m1.containsKey(str)||!m1.get(str).equals(m2.get(str))){
                ans=false;
                break;
            }
        }
        return ans;
    }
    boolean cmpp(Map<String, Integer> m1, Map<String, Integer> m2) {
        if (m1.size() != m2.size()) return false;
        for (String k1 : m1.keySet()) {
            if (!m2.containsKey(k1) || !m1.get(k1).equals(m2.get(k1))) return false;
        }
        for (String k2 : m2.keySet()) {
            if (!m1.containsKey(k2) || !m1.get(k2).equals(m2.get(k2))) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}