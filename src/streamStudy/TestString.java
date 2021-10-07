package streamStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestString {
    public static int ans=0;
    public static int[]a;
    public static int[] distinctAndSorted;
    public static List<String[]> list;
    public static void main(String[] args) {
        /*先找出最佳的p值，然后获取费零段的个数
        * 关键在于如何找到这个p值，求非零段个数倒是简单
        * 二分查找最合适的p值？
        * 去重排序，然后每次取中间值，统计对应非零段个数，并维护ans
        * */
        a=new int[]{5 ,1, 20, 10, 10, 10, 10, 15, 10, 20, 1, 5, 10, 15};
        list=new ArrayList<>();
        String saobi=Arrays.stream(a).boxed().map(e->{
            if((int)e<=10){
                e=0;
            }
            return e;
        }).map(e->{return e.toString();}).collect(Collectors.joining());

        int nct=0;
        for(String s:saobi.split("0+")){
            if(s!=" ")
                ++nct;
        }
        System.out.println(Arrays.toString(saobi.split("0+")));
        System.out.println("第0号元素是"+saobi.split("0+")[0]);
        System.out.println("nct是："+nct);
        distinctAndSorted=Arrays.stream(a).boxed().distinct().sorted().mapToInt(Integer::intValue).toArray();
        dfs(distinctAndSorted,0,distinctAndSorted.length-1);
        System.out.println(ans);
        for(String[]ele:list){
            System.out.println(Arrays.toString(ele));
        }
    }
    /*获取非零段的个数*/
    public static int getOntZeroNum(int[]y){
        String str=Arrays.stream(y).boxed().map(o->{return o.toString();}).collect(Collectors.joining());
        String[]uu=str.split("0+");
        return uu.length;
    }
    /*递归统计，维护ans*/
    public static void dfs(int[]q,int left,int right){
        if(left>right)return;
        int mid=(left+right)/2;

        String str=Arrays.stream(a).boxed().map(obj->{
            if((int)obj<=q[mid]){
                obj=0;
            }
            return obj;
        }
        ).map(Object::toString).collect(Collectors.joining());
        int cnt=0;
        for(String s:str.split("0+")){
            if(s!="")
                ++cnt;
        }
        if(cnt>ans){
            ans=cnt;
            list.add(str.split("0+"));
        }
        dfs(q,left,mid-1);
        dfs(q,mid+1,right);
    }
}
