package _22_Graph;
import java.util.*;
public class Connectingcities {
    static class Edge implements Comparable<Edge> {
        int dest,cost;
        public Edge(int d, int c) {
          this.dest=d;
          this.cost=c;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.cost-e2.cost;
        }   
    }
    public static int connectcities(int cities[][]) {
        int n=cities.length;
        boolean vis[]=new boolean[n];
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Edge(0,0));
        int finalcost=0;
        while(!pq.isEmpty()) {
            Edge curr=pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest]=true;
                finalcost+=curr.cost;
                for(int i=0;i<cities[curr.dest].length;i++) {
                    if(cities[curr.dest][i]!=0 && !vis[i]) {
                        pq.add(new Edge(i,cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }
    public static void main(String[] args) {
        int cities[][]={
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        System.out.println(connectcities(cities));}
}

