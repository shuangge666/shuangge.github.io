# 重要题目
### 1.MaximumWidthOfBinaryTree
这道题目是bfs的典型应用，其中每层元素出队的操作以及通过queue.size()求解当前层的个数很重要

### 2.FindModeInBinarySearchTree
这道题是求解二叉搜索树中的所有众数，如果不用到二叉搜索树的性质那么直接使用哈希表记录meiyge
元素的出现次数；但是，二叉搜索树的性质就是中序遍历得到的序列是有序的，如果一个数的分布一定是连续的，
这里就用到了“树遍历的双指针技巧”，使用两个指针，pre和cur，比较pre和cur的值，然后进行操作。
可以对比数组的双指针，如果把二叉搜索树的终须遍历序列存进一个数组，也是需要两个指针。

### 3. 第530题 二叉搜索树的最小绝对值差
这道题和上面寻找二叉树众数的思路一样，都是利用二叉搜索树中序遍历有序的特点，
利用树上双指针进行比较。树上双指针，很重要

### 4. 98题 验证二叉搜索树
这道题还是使用了树上双指针，利用树上双指针判定中序遍历相邻两个节点值的大小关系，
只有满足单调递增才是二叉搜索树。

### 5. 513题 找树左下角的值
这道题思路是用广度优先搜索，将每层的节点List放入一个外层List，最后一层最左边的节点的值就是外层List
最后一个元素(也是一个List)的第0个元素的val。

### 6. 718题 最长重复子数组和 1143. 最长公共子序列 
首先，一般涉及到比较两个数组或者字符串的问题，dp数组都是二维的，一维用于推nums1,一维用于推nums2
这两道题简直是神仙题目，太经典了！！！最长重复子数组是求数组(或者字符串)中连续的子数组(串)的最大长度的模板，
最长公共子序列是求数组或字符串中离散的公共子序列的最大长度的模板。二者的区别在于递推公式和dp数组的定义，以及
是否需要维护一个ans以记录最大值(最长重复子数组需要，LCS不需要)。



- 最长重复子数组的题解
```java
public class MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //最长公共子序列的dp[i][j]含义：nusm1前i个元素和nums2前j个元素的最长公共子数组的长度
        //最长重复子数组dp[i][j]含义：以nums1[i-1]结尾的子数组和以nums2[j-1]结尾的子数组的最长公共子数组的长度
        //对比：最长公共子序列求得的"序列"De最大长度，序列在原数组中不一定是连续的，所以等价于是离散的，所以
        //递推公式中直接比较text1[i-1]和text2[j-1]是否相等，如果相等当然是dp[i-1][j-1]+1,如果不等，由于是离散的
        //,所以dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //而最长重复子数组中，要求的是子数组，这段子数组是连续的，这种情况dp[i][j]的含义就是以nums1[i-1]结尾且以
        //nums2[j-1]结尾的最长重复子数组的长度。如果nums1[i-1]和nums2[j-1]相等，当然dp[i][j]=dp[i-1][j-1]+1;
        //但是如果不等，那么说明不存在既以nums1[i-1]结尾有以nums2[j-1]结尾的最长重复子数组，所以dp[i][j]=0,并且由于求得的
        //最长的重复子数组长度，所以要维护一个变量ans，在递推过程中不断更新ans，使得ans取得的是最大值，最后返回ans即可。
        int[][]dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        for(int i=1;i<= nums1.length;++i){
            for(int j=1;j<=nums2.length;++j){
                if(nums1[i-1]==nums2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else{
                    dp[i][j]=0;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

```

- LCS题解
 ```java
public class LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]含义：text 1前i个字符和text2前j个字符的最大公共子序列的长度
        int[][]dp=new int[text1.length()+1][text2.length()+1];
        //text[i-1]==text[j-1]::dp[i][j]=dp[i-1][j-1]+1
        //text[i-1]!=text[j-1]::dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])
        for(int i=1;i<=text1.length();++i)
            for(int j=1;j<=text2.length();++j){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        return dp[text1.length()][text2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

```
### 7.  53最大子序列和
第53题求解的是最大连续子序列的和，看到连续子序列，所以dp数组的定义应该是dp[i]代表以nums[i]结尾的连续子数组的最大和
，并且还要维护一个ans记录递推过程中的最大值，这是第一反应就应该做出来的判断。
然后，看递推公式。比如nums=[2,1,-3,4,-1,2,1,-5,4],对于dp[i],如果dp[i-1]<0，那肯定不能加上dp[i-1]，不然就变小了，
所以dp[i]=nums[i];如果dp[i-1]>0,当然就得加上dp[i-1];在判断结束后，更新ans，使得ans最大。

### 8. 220.存在重复元素 TreeSet+滑动窗口
TreeSet是基于TreeMap而来，底层是红黑树，查找为logn,插入、删除最多自旋3次
TreeSet的floor(value)，返回小于等于value的最大值，如果集合中没有就返回null；
ceiling(Value)，返回集合中大于等于value的最小值，如果集合中没有就返回null；
lower(value),返回集合中小于value的最大值
暴力算法是二重循环。可以使用使用TreeSet优化内层循环，因为TreeSet的查找是logn，
使用floor查找小于等于nums[i]的最大元素；使用ceiling(nums[i])查找大于等于i的
最大值，找到了且满足调价肯定就存在这样的i，j，返回true；
题解：https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/

### 9.424题 替换后的最长重复字符
这道题是一道经典的滑动窗口题目，字节跳动考了。官方题解：
https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-eaacp/
