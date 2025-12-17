package _22_Graph;

import java.util.ArrayList;

public class Articulationpoint {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Graph creation
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Example Graph (undirected)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    // DFS for Tarjan’s Algorithm
    public static void dfs(ArrayList<Edge>[] graph, int curr, int parent,
                           boolean[] vis, int[] dt, int[] low, int time, boolean[] ap) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (Edge e : graph[curr]) {
            if (e.dest == parent) continue;

            if (!vis[e.dest]) {
                dfs(graph, e.dest, curr, vis, dt, low, time, ap);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // Articulation Point condition (non-root)
                if (parent != -1 && dt[curr] <= low[e.dest]) {
                    ap[curr] = true;
                }
                children++;
            } else {
                // Back edge
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }

        // Special case: root node
        if (parent == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void articulationPoints(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        int[] dt = new int[V];   // discovery time
        int[] low = new int[V];  // low values
        boolean[] ap = new boolean[V]; // articulation points

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, 0, ap);
            }
        }

        System.out.println("Articulation Points are:");
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        articulationPoints(graph, V);
    }
}
