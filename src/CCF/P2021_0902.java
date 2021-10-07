package CCF;

import java.io.*;
import java.util.Arrays;

public class P2021_0902 {
    public static StreamTokenizer cin=new StreamTokenizer(new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in))));
    public static PrintWriter cout=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out))));
    public static int n;
    public static int[]A;
    public static int[]ref=new int[1];
    public static int readInt(){
        int ans=0;
        try{
            cin.nextToken();
            ans=(int)cin.nval;
        }
        catch(Exception e){}
        return ans;
    }
    public static int getNOtZeroNum(int[]arr){
        int num=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]!=0){
                while(i<arr.length&&arr[i]!=0)
                    ++i;
                ++num;
            }
            else{
                while(i<arr.length&&arr[i]==0)
                    ++i;
            }
        }
        return num;
    }
    public static int count(int[]a,int val){
        int[]aCopy=Arrays.copyOfRange(a,0,a.length);
        int num=0;
        for(int i=0;i<a.length;++i){
            if(aCopy[i]<=val)
                aCopy[i]=0;
        }
        num=getNOtZeroNum(aCopy);
        return num;
    }
    public static void dfs(int[]arr,int left,int right){
        if(left>right)
            return;
        int mid=(left+right)/2;
        ref[0]=Math.max(ref[0],count(A,arr[mid]));
        dfs(arr,left,mid-1);
        dfs(arr,mid+1,right);
    }

    public static void main(String[] args) {
        n=readInt();
        A=new int[n+1];
        for(int i=1;i<A.length;++i)
            A[i]=readInt();
        int[]b= Arrays.stream(A).boxed().parallel().distinct().sorted().mapToInt(Integer::intValue).toArray();
        ref[0]=getNOtZeroNum(A);
        dfs(b,0,b.length-1);
        System.out.println(ref[0]);
    }
}
