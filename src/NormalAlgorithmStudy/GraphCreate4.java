package NormalAlgorithmStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 唐良爽
 * @version 1.0
 * Created by Intellij IDEA
 */

public class GraphCreate4 {
    /*以邻接表形式构建图*/
    public static List<List<Node>>graph=new ArrayList<>();
    public static void main(String[] args) {
        int nodeNum,edgeNum;
        int from,to,w;
        Scanner in=new Scanner(System.in);
        nodeNum=in.nextInt();
        edgeNum=in.nextInt();
        for(int i=0;i<nodeNum;++i){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edgeNum;++i){
            from=in.nextInt();
            to=in.nextInt();
            w=in.nextInt();
            Node node=new Node(to,w);
            graph.get(from).add(node);
            graph.get(to).add(new Node(from,w));
        }
        AtomicInteger cnt= new AtomicInteger();
        graph.forEach(o->{
            System.out.println("from: "+cnt+" ,to and w: "+o.toString());
            cnt.incrementAndGet();
        });
        /*
        3 3
        2 1 12
        1 0 10
        0 2 20
        */
    }
    public static class Node{
        int to;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        int w;

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", w=" + w +
                    '}';
        }
    }
}
