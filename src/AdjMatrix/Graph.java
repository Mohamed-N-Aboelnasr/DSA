package AdjMatrix;

public class Graph {

    private int V;  // no of vertices
    private int E;  // no of edges
    private int[][] adjMatrix;  //Representation of undirected graph

    public Graph(int nodes){
        this.V = nodes;
        this.E = 0;
        adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v){
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
        this.E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.V + " Vertices, " + this.E + " Edges" + "\n");
        for(int v=0; v<V; v++){
            sb.append(v + ": ");
            for(int e : adjMatrix[v]){
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        System.out.println(graph);
    }
}
