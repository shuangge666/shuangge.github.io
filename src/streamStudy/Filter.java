package streamStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList(Arrays.asList(5,6,2,0,8,12,0,4,2,1,0,0,4,0,2,0,11,1,0,6));
        long ss=System.currentTimeMillis();
        ArrayList<Integer> collect = (ArrayList)list.parallelStream().filter(o1 -> (int) o1 > 6).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
        long se=System.currentTimeMillis();

        long ks=System.currentTimeMillis();
        List<Integer>test=new ArrayList<>();
        for(Integer k:list){
            if(k>6)
                test.add(k);
        }
        System.out.println(test);
        long ke=System.currentTimeMillis();

        System.out.println("用流过滤的时间："+(se-ss));
        System.out.println("直接过滤的时间："+(ke-ks));
    }
}
