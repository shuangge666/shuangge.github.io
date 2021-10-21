package streamStudy;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class TreeSetStudy {
    public static void main(String[] args) {
        TreeSet<Integer>set=new TreeSet<>();
        List<Integer> list= Arrays.asList(6,9,1,4,68,2,3);
        set.addAll(list);
        Integer ans=set.lower(9);
        System.out.println(ans);
        System.out.println((int)-3/-4);
    }
}
