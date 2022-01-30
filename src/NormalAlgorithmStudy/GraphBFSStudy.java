package NormalAlgorithmStudy;

import java.util.*;

/**
 * @author 唐良爽
 * @version 1.0
 * Created by Intellij IDEA
 */

public class GraphBFSStudy {
    public static List<List<Node>>g=new ArrayList<>();
    public static int[]dis=new int[105];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;++i){
            g.add(new ArrayList<>());
        }
        for(int i=1;i<=n;++i){
            int from=in.nextInt();//顶点编号，其实已知了
            int degree=in.nextInt();//该顶点的度
            int to=0;//另一顶点
            for(int j=0;j<degree;++j){
                to=in.nextInt();
                g.get(from-1).add(new Node(to-1,0));//有向图，只加一次
            }
        }
        bfs(0,0);
        for(int i=0;i<n;++i){
            System.out.println((1+i)+" "+dis[i]);
        }
        /*
        4
1 2 2 4
2 1 4
3 0
4 1 3
         */
    }
    public static void bfs(int root,int d){
        LinkedList<Integer>queue=new LinkedList<>();
        queue.add(root);
        dis[root]=d;
        Arrays.fill(dis,0);
        while(!queue.isEmpty()){
            int top=queue.poll();
            for(int i=0;i<g.get(top).size();++i){
                if(dis[g.get(top).get(i).to]!=0)continue;
                queue.add(g.get(top).get(i).to);
                dis[g.get(top).get(i).to]=dis[top]+1;
            }
        }
    }
    public static class Node{
        int to;
        int w;

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

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", w=" + w +
                    '}';
        }
    }
}
