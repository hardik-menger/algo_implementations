package Utils;

class DisjointSet2 {
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges

    class Edge {
        int src, dest;
    };

    class subset
    {
        int parent;
        int rank;
    }

    int find(subset[] parents,int x){
        if(parents[x].parent!=x)
            parents[x].parent=find(parents, parents[x].parent);
        return parents[x].parent;
    }

    void union(subset[] parents,int x,int y){
        int xn=find(parents, x);
        int yn=find(parents, y);
        if(parents[xn].rank<parents[yn].rank)
            parents[xn].parent=yn;
        else if(parents[yn].rank>parents[xn].rank)
            parents[yn].parent=xn;
        else{
            parents[xn].parent=yn;
            parents[yn].rank++;
        }
    }


    // Creates a graph with V vertices and E edges
    DisjointSet2(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

     int isCycle(DisjointSet2 graph)
    {
        int V = graph.V;
        int E = graph.E;
 
        subset[] subsets = new subset[V];
        for (int v = 0; v < V; v++) {
 
            subsets[v] = new subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if (x == y)
                return 1;
            union(subsets, x, y);
        }
        return 0;
    }
    public static void main (String[] args)
    {
        int V = 3, E = 3;
        DisjointSet2 graph = new DisjointSet2(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
 
        if (graph.isCycle(graph) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println(
                "Graph doesn't contain cycle");
    }
}
