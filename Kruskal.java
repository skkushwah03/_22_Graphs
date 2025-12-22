package _22_Graph;
import java.util.ArrayList;
import java.util.Collections;
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    static void createGraph(ArrayList<Edge> Edge){
        Edge.add(new Edge(0, 1, 10));
        Edge.add(new Edge(0, 2, 15));
        Edge.add(new Edge(0, 3, 30));
        Edge.add(new Edge(1, 3, 40));
        Edge.add(new Edge(2, 3, 50));
    }
    static int n=4;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rank[rootA]==rank[rootB]){
            par[rootB]=rootA;
            rank[rootA]++;
        }
        else if(rank[rootA]>rank[rootB]){
            par[rootB]=rootA;
        }
        else{
            par[rootA]=rootB;
        }
    }
    public static void kruskal(ArrayList<Edge> edges,int V){
        init();
        Collections.sort(edges);
        int count=0;
        int cost=0;
        for(int i=0;count<V-1 && i<edges.size();i++){
            Edge e=edges.get(i);
            int srcParent=find(e.src);
            int destParent=find(e.dest);
            if(srcParent!=destParent){
                union(e.src,e.dest);
                cost+=e.weight;
                count++;
            }
        }
        System.out.println("Minimum Cost: "+cost);
       
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges=new ArrayList<>();
        createGraph(edges);
        kruskal(edges,V);
     }
    
}
