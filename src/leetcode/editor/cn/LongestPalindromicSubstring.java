package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4214 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String ans=solution.longestPalindrome("aaaa");
        System.out.println(ans);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        return dp(s);
    }
    //方法1：动态规划解法
    public String dp(String s){
        //dp[i][j]含义：s[i]至s[j]这一段子串是不是回文串
        //递推公式：dp[i][j]=(s[i]==s[j])&&(dp[i+1][j-1])
        boolean[][]dp=new boolean[s.length()+1][s.length()+1];
        int ans=Integer.MIN_VALUE;
        String str="";
        if(s.length()==1)
            return s;
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            }
            else
                return s.substring(0,1);
        }
        for(int i=s.length()-2;i>=0;--i)//注意递推公式中dp[i][j]是依赖于dp[i+1][j-1]，所以i要逆推，j要顺推
            for(int j=i+1;j<s.length();++j){
                dp[i][j]=(s.charAt(i)==s.charAt(j)&&(dp[i+1][j-1]||(j-i)<3));
                if(dp[i][j]){
                    if(j-i+1>ans){
                        str=s.substring(i,j+1);
                        ans=j-i+1;
                    }
                }

            }
        return str.equals("")?s.substring(0,1):str;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}