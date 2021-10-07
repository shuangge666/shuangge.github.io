package CCF;

import java.io.*;

public class P2021_0901 {
    /*OK的程序*/
    public static StreamTokenizer cin=new StreamTokenizer(new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in))));
    public static PrintWriter cout=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out))));
    public static void main(String[] args) {
        int n=readInt();
        int[]B=new int[n];
        for(int i=0;i<n;++i)
            B[i]=readInt();
        int maxVal=B[0];
        int minVal=B[0];
        for(int i=0;i+1<B.length;++i){
            if(B[i]==B[i+1]){
                maxVal+=B[i+1];
                minVal+=0;
            }
            else if(B[i]<B[i+1]){
                maxVal+=B[i+1];
                minVal+=B[i+1];
            }
        }
        cout.println(maxVal);
        cout.print(minVal);
        cout.flush();
    }
    public static int readInt(){
        int ans=0;
        try{
            cin.nextToken();
            ans=(int)cin.nval;
        }
        catch(Exception e){}
        return ans;
    }
}
