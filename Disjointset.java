package _22_Graph;
import java.util.*;
public class Disjointset {
    static int n=7;
    static int parent[]=new int[n];
    static int rank[]=new int[n];
    public static void init(){
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public static void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            if(rank[rootA]==rank[rootB]){
                parent[rootB]=rootA;
                rank[rootA]++;
            }
            else if(rank[rootA]>rank[rootB]){
                parent[rootB]=rootA;
            }
            else{
                parent[rootA]=rootB;
            }
        }
    }
 public static void main(String[] args) {
    init();
   union(1,3 );
   union(2,4);
   union(3,6);
   union(1,4);
   System.out.println(find(3));
   System.out.println(find(4));
   union(1, 5);
    for(int i=0;i<n;i++){
        System.out.println(i+" -> "+find(i));
    }
 }   
}
