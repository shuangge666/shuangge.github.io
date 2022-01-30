package NormalAlgorithmStudy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author 唐良爽
 * @version 1.0
 * Created by Intellij IDEA
 */

public class GraphDFSStudy {
    public static List<List<Node>>g=new ArrayList<>();
    public static int[]ddd=new int[105];
    public static int[]fff=new int[105];
    static boolean[]vis=new boolean[105];
    static int cnt=1;
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
        dfs(0);
        for(int i=0;i<n;++i){
            System.out.println((i+1)+" "+ddd[i]+" "+fff[i]);
        }
        /*
        输入：
6
1 2 2 3
2 2 3 4
3 1 5
4 1 6
5 1 6
6 0

        输出：
        1 1 12
        2 2 11
        3 3 8
        4 9 10
        5 4 7
        6 5 6
         */

    }
    public static void dfs(int root){
        if(vis[root])
            return;
        vis[root]=true;
        ddd[root]=cnt++;
        Collections.sort(g.get(root),(o1,o2)->{return o1.getTo()-o2.getTo();});
        for(Node node:g.get(root)){
            if(vis[node.getTo()])continue;
            dfs(node.to);
        }
        fff[root]=cnt;
        ++cnt;
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
