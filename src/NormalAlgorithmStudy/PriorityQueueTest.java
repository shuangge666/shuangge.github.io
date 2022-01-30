package NormalAlgorithmStudy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 唐良爽
 * @version 1.0
 * Created by Intellij IDEA
 * 主要测试PriorityQueue等集合的remove((Object)obj)方法
 * 因为我不确定当集合(非Set及其子类对象)中含有多个相同的值时，remove((Object)obj)方法
 * 是将所有为obj的值全部移除还是只移除一个obj
 *
 */

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int[]arr=new int[]{6,8,1,2,4,6,9,3,2};
        for(Integer v:arr){
            pq.offer(v);
        }
        System.out.println("为移除元素前的pq：");
        System.out.println("\t"+pq);
        System.out.println("移除元素6后的pq：");
        pq.remove((Object)6);
        System.out.println("\t"+pq);
        System.out.println("移除元素2后的pq：");
        pq.remove((Object)2);
        System.out.println("\t"+pq);

        List<Integer>list=new ArrayList<>(Arrays.asList(9,3,42,4,5,6,6,7,9,2,3,1,2,6,3,1));
        System.out.println(list);
        list.remove((Object)6);
        System.out.println(list);
    }
}
