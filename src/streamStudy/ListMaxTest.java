package streamStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListMaxTest {
    public static void main(String[] args) {

        int[]arr=new int[]{2,6,8,90,2,1,3};
        List<Integer> mm= new ArrayList<Integer>(Arrays.asList(2,6,8,90,1,4,7));
        System.out.println(Collections.max(mm));
    }
}
