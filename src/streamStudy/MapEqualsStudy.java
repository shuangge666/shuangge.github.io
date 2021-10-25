package streamStudy;

import java.util.HashMap;
import java.util.Map;

public class MapEqualsStudy {
    public static void main(String[] args) {
        Map<String,Integer>map1=new HashMap<>();
        Map<String,Integer>map2=new HashMap<>();
        map1.put("司薏楠",1);
        map1.put("熊文慧",2);
        map1.put("刘蕊宁",3);
        map2.put("司薏楠",1);
        map2.put("熊文慧",2);
        map2.put("刘蕊宁",3);
        System.out.println(map1.equals(map2));//使用Map的equals()方法可以比较两个map的Map.Entry是狗相等
        System.out.println(map1==map2);
    }
}
