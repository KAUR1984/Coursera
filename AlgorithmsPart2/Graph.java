package Coursera.AlgorithmsPart2;

import java.util.*;

//USING THE "ADJACENCY GRAPH LINKED LIST" REPRESENTATION
public class Graph {
    private int v;    //number of vertices of the graph
    private List<HashSet<Integer>> adj;    //AVOID USING ARRAYS FOR GENERIC TYPES, JUST USE AN ARRAY LIST!!!
    //LOTS OF TIME TO FIGURE THAT OUT !!! :-P

    //Create an empty graph with v vertices
    public Graph(int v){
        this.v = v;
        adj = new ArrayList<>(v);   //size returns the number of elements in the list!
        for(HashSet<Integer> adjs : adj){
            adjs = new HashSet<>();
        }
    }

    //Add an edge
    void addEdge(int v, int w){
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    //Vertices adjacent to v
    Iterable<Integer> adj(int v){
        return adj.get(v);   //just return the set of adjacent vertices
    }

    //return the number of vertices
    int V(){
        return v;
    }

    //return the number of edges
    int E(){           //TODO
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    //Compute the degree of vertex v
    public static int degree(Graph g, int v){
        int degree = 0;
        for(int w = 0;  w < g.V(); w++){
            degree++;
        }
        return degree;
    }

    //compute the maximum degree
    public static int maxDegree(Graph g){
        int max = 0;
        for(int v = 0; v < g.V(); v++) {
            if(degree(g,v) > max)
                max = degree(g,v);
        }
        return max;
    }

    //compute the average degree
    public static int avgDegree(Graph g){
        return 2*g.E()/g.V();
    }

    //Count number of self loops
    public static int countSelf(Graph g){
        int count = 0;
        for(int v = 0; v < g.V(); v++){
            for(int w : g.adj(v)) {   //iterate over all of the adjacent vertices
                if(w == v)
                    count++;
            }
        }
        return count/2;   //each edge is counted twice
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        Graph g = new Graph(13);      //read graph from the input stream

//        while(in.hasNextLine()){
//            int v1 = in.nextInt();
//            int v2 = in.nextInt();
//
//            g.addEdge(v1,v2);
//            System.out.println(v1 + "-" + v2 + " made an edge");
//        }

        g.addEdge(4,3);
        for(int v = 0; v < g.V(); v++) {
            for(int w : g.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }
}
