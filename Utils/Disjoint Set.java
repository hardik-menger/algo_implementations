package Utils;

class DisjointSet {
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges

    class Edge {
        int src, dest;
    };

    // Creates a graph with V vertices and E edges
    DisjointSet(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(int parents[], int parent) {
        if (parents[parent] == -1)
            return parent;
        else
            return find(parents, parents[parent]);
    }

    void union(int parents[], int child, int parent) {
        parents[child] = parent;
    }

    int isCycle(DisjointSet graph) {
        int parents[] = new int[graph.V];
        for (int i = 0; i < graph.V; ++i)
            parents[i] = -1;
        for (int i = 0; i < graph.E; ++i) {
            int x = find(parents, graph.edge[i].src);
            int y = find(parents, graph.edge[i].dest);
            if (x == y)
                return 1;
            else
                union(parents, x, y);
        }
        return 0;
    }

    public static void main (String[] args)
    {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        DisjointSet graph = new DisjointSet(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
 
        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
