package streamStudy;

import java.util.Arrays;

public class ReduceStudy {
    public static void main(String[] args) {
        int[]arr=new int[]{2,4,6,8,10,89};
        int ans= Arrays.stream(arr).boxed().reduce(0,(o1, o2)->{return o1+o2;});
        System.out.println(ans);
    }
}
