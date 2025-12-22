package _22_Graph;

import java.util.*;

public class Kosarajus {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        } 
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4)); 
    }
    public static void topSort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer>s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
             if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
   public static void Kosaraju(ArrayList<Edge> graph[], int v) {
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[v];

    // Step 1: Topological sort
    for (int i = 0; i < v; i++) {
        if (!vis[i]) {
            topSort(graph, i, vis, s);
        }
    }

    // Step 2: Transpose graph
    ArrayList<Edge>[] transpose = new ArrayList[v];
    for (int i = 0; i < v; i++) {
        transpose[i] = new ArrayList<Edge>();
    }

    for (int i = 0; i < v; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            transpose[e.dest].add(new Edge(e.dest, e.src)); // reverse edge
        }
    }

    // Step 3: DFS on transpose graph in stack order
    Arrays.fill(vis, false);  // 🔥 Reset visited before 2nd DFS
    while (!s.isEmpty()) {
        int curr = s.pop();
        if (!vis[curr]) {
            System.out.print("SCC -> ");
            dfs(transpose, curr, vis);
            System.out.println();
        }
    }
}

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        Kosaraju(graph,V);
    }
}
