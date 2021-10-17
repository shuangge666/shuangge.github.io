package streamStudy;

import java.util.Arrays;

public class ArraysStudy {
    public static void main(String[] args) {
        int[]arr=new int[100000];
        Arrays.fill(arr,666);
        arr[1324]=78;
        long s1=System.currentTimeMillis();
        int index= Arrays.binarySearch(arr,78);
        long s2=System.currentTimeMillis();
        System.out.println("Arrays.binarySearch获得的索引是："+index+"耗时为："+(s2-s1));
        int val=arr[0];
        long s3=System.currentTimeMillis();
        for(int i=0;i<arr.length;++i){
            if(arr[i]==78){
                val=i;
                break;
            }
        }
        long s4=System.currentTimeMillis();
        System.out.println("线性遍历获得的索引是："+val+"耗时为："+(s4-s3));
    }
}
