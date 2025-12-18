package _22_Graph;
import java.util.*;

public class Cheapestflightkstop {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    } 

    public static void createGraph(int flights[][], ArrayList<Edge>[] graph, int n) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }  

    static class Info {
        int v, cost, stops;
        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph, n);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) continue; // skip this path but continue BFS

            for (Edge e : graph[curr.v]) {
                int v = e.dest;
                int newCost = curr.cost + e.wt;

                if (newCost < dist[v] && curr.stops <= k) {
                    dist[v] = newCost;
                    q.add(new Info(v, newCost, curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int src = 0, dst = 3, k = 1;

        System.out.println(cheapestFlight(n, flights, src, dst, k));
        // Expected Output: 700 (0 -> 1 -> 3 within 1 stop)
    }
}
