package leetcode.editor.cn;

//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意。 
// 
//
// 示例： 
//
// 
//输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 滑动窗口 👍 194 👎 0

public class GrumpyBookstoreOwner{
    public static void main(String[] args) {
        Solution solution = new GrumpyBookstoreOwner().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int []preSum=new int[customers.length];
        preSum[0]=grumpy[0]==0?customers[0]:0;
        for(int i=1;i<=preSum.length-1;++i){
            if(grumpy[i]==0){//0代表不生气，1代表生气，别看反了！！！
                preSum[i]=preSum[i-1]+customers[i];
            }
            else
                preSum[i]=preSum[i-1];
        }
        int left=0,right=0,tmp=0,ans=0,other=0;
        for(;right<customers.length;++right){
            while(right<customers.length&&right-left+1<=minutes){
                tmp+=customers[right];
                ++right;
            }
            --right;
            if(left==0){
                other=preSum[customers.length-1]-preSum[right];
            }
            else{
                other=preSum[left-1]+preSum[customers.length-1]-preSum[right];
            }
            ans=Math.max(ans,tmp+other);
            tmp-=customers[left];
            ++left;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}