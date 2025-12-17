package _22_Graph;
import java.util.ArrayList;
public class Bellmanford {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void creategraph(ArrayList <Edge> graph[]){
       for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
       }
       graph[0].add(new Edge(0, 1, 2));
       graph[0].add(new Edge(0, 2, 4));
       graph[1].add(new Edge(1, 2, -4));
       graph[2].add(new Edge(2, 3, 2));
       graph[3].add(new Edge(3, 4, 4));
       graph[4].add(new Edge(4, 1, -1));
    }
   
    public static void bellmanford(ArrayList <Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        //Relaxation
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt<dist[v] && dist[u]!=Integer.MAX_VALUE){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        //print the distance array
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    
    static void creategraph2(ArrayList <Edge> graph){
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
     }
    
    public static void belmanfrd(ArrayList <Edge> graph, int src,int V){
        int dist[] = new int[V];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        //Relaxation
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.size();j++){
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u]+wt<dist[v] && dist[u]!=Integer.MAX_VALUE){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        //print the distance array
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
     public static void main(String[] args) {
        int V=5;
        ArrayList <Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        bellmanford(graph, V);

        ArrayList <Edge> graph2=new ArrayList<>();
        creategraph2(graph2);
        belmanfrd(graph2,0, V);
    }
}
