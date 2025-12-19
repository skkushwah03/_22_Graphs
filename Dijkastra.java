package _22_Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkastra {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // vertex 1
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // vertex 2
        graph[2].add(new Edge(2, 4, 3));

        // vertex 3
        graph[3].add(new Edge(3, 5, 1));

        // vertex 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int n, int path) {
            this.node = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; // important fix

        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print result
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src, V);
    }
}



// package _22_Graph;
// import java.util.ArrayList;
// import java.util.PriorityQueue;
// public class Dijkastra {
//      static class Edge {
//         int src;
//         int dest;
//         int wt;

//         public Edge(int s, int d, int w) {
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }
//     static void createGraph(ArrayList<Edge>[] graph) {
//         for(int i=0; i<graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         // vertex 0
//         graph[0].add(new Edge(0, 1, 2));
//         graph[0].add(new Edge(0, 2, 4));

//         // vertex 1
//         graph[1].add(new Edge(1, 3, 7));
//         graph[1].add(new Edge(1, 2, 1));

//         // vertex 2
//         graph[2].add(new Edge(2, 4, 3));
        
//         graph[3].add(new Edge(3, 5, 1));
        

//         // vertex 4
//         graph[4].add(new Edge(4, 3, 2));
//         graph[4].add(new Edge(4, 5, 5));
//     }

//     static class Pair implements Comparable<Pair> {
//         int node;
//         int path;

//         public Pair(int n, int path) {
//             this.node = n;
//             this.path = path;
//         }
//         @Override
//         public int compareTTo(Pair p2){
//             return this.path-p2.path;
//         }
//     }

//     public static void printGraph(ArrayList<Edge>[] graph,int src) {
//         for(int i=0; i<graph.length; i++) {
//             for(int j=0; j<graph[i].size(); j++) {
//                 System.out.print("("+graph[i].get(j).src+"->"+graph[i].get(j).dest+"@"+graph[i].get(j).wt+") ");
//             }
//             System.out.println();
//         }
//     }

//     public static void dijkstra(ArrayList<Edge>[] graph, int src, int V) {
//         int dist[] = new int[graph.length];
//         for(int i=0; i<graph.length; i++) {
//             if(i!=src) {
//                 dist[i] = Integer.MAX_VALUE;
//             }
//         }

//         boolean vis[] = new boolean[V];
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.path - b.path);
//         pq.add(new Pair(src, 0));

//         while(!pq.isEmpty()) {
//             Pair curr = pq.remove();
//             if(!vis[curr.node]) {
//                 vis[curr.node] = true;

//                 for(int i=0; i<graph[curr.node].size(); i++) {
//                     Edge e = graph[curr.node].get(i);
//                     int u = e.src;
//                     int v = e.dest;
//                     int wt = e.wt;

//                     if(dist[u] + wt < dist[v]) {
//                         dist[v] = dist[u] + wt;
//                         pq.add(new Pair(v, dist[v]));
//                     }
//                 }
//             }
//         }

//         for(int i=0; i<dist.length; i++) {
//             System.out.print(dist[i]+" ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int V = 6;
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(graph);
//         int src=0;
//         dijkstra(graph, src, V);
//     }
// }
