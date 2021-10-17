package leetcode.editor.cn;

//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划
// 👍 1206 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak{
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //每个单词可以无限选择，那么是完全背包问题
        //判断给定字符串s是否能够被空格拆分成列表中的一个或者多个元素，相当于s就是背包容量，每个元素的重量就是元素的值(一个小字符串)
        //上一行对于背包的定义不好，应为把索引(dp[i]的i)由整数变成了字符串，得用哈希表，可就麻烦了
        //正确定义应该是dp[j]代表长度为j的字符串是否能够被空格拆分成列表中的一个或者多个元素
        //那么：(1)背包:s.length()  (2)物品：s上的子串，并且要检查这个子串是否在wordDict中
        boolean[]dp=new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0]=true;
        for(int j=1;j<=s.length();++j){//要求解子串，应该先遍历背包容量(s.length()),再遍历物品(子串)，这样直接可以substring，否则要把
            //子串放到一个容器中
            for(int i=0;i<j;++i){
                String tmp=s.substring(i,j);
                if(wordDict.contains(tmp)&&dp[i]){
                    dp[j]=true;
                }
            }
        }

        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
