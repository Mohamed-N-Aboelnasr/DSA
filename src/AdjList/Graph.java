package AdjList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int V;  // no of vertices
    private int E;  // no of edges
    private LinkedList<Integer>[] adjList;  //Representation of undirected graph

    public Graph(int nodes){
        this.V = nodes;
        this.E = 0;
        adjList = new LinkedList[nodes];
        for(int v=0; v<V; v++){
            adjList[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        this.adjList[u].add(v);
        this.adjList[v].add(u);
        this.E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.V + " Vertices, " + this.E + " Edges" + "\n");
        for(int v=0; v<V; v++){
            sb.append(v + ": ");
            for(int e : adjList[v]){
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int v){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        while(!queue.isEmpty()){
            int vertix = queue.poll();
            System.out.print(vertix + " ");
            for(int temp : adjList[vertix]){
                if(!visited[temp]){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
    }

    public void dfs(int v){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while(!stack.isEmpty()){
            int vertix = stack.pop();
            if(!visited[vertix]) {
                visited[vertix] = true;
                System.out.print(vertix + " ");
                for (int temp : adjList[vertix]) {
                    if (!visited[temp]) {
                        stack.push(temp);
                    }
                }
            }
        }
    }

    //Recursive approach
    public void dfs(){
        boolean[] visited = new boolean[V];
        for(int v=0; v<V; v++){
            if(!visited[v]){
                dfs(v,visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int vertix: adjList[v]){
            if(!visited[vertix])
                dfs(vertix,visited);
        }
    }

    // for connected component
    public void dfsComp(){
        boolean[] visited = new boolean[V];
        int[] compId = new int[V];
        int count = 0;
        for(int v=0; v<V; v++){
            if(!visited[v]){
                dfs(v,visited,compId,count);
                count++;
            }
        }
    }

    private void dfs(int v, boolean[] visited, int[] compId, int count) {
        visited[v] = true;
        compId[v] = count;
        System.out.print(v + " ");
        for(int vertix: adjList[v]){
            if(!visited[vertix]){
                dfs(vertix,visited,compId,count);
            }
        }
    }

    public int noOfIslands(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int noOfIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(matrix,i,j,visited);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private void dfs(char[][] matrix, int row, int col, boolean[][] visited) {
        if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length || visited[row][col] || matrix[row][col]=='0')
            return;
        visited[row][col] = true;
        dfs(matrix,row,col-1,visited);  // go left
        dfs(matrix,row-1,col,visited);  // go up
        dfs(matrix,row,col+1,visited);  // go right
        dfs(matrix,row+1,col,visited);  // go down

    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);
//        System.out.println(graph);
        graph.bfs(0);
        System.out.println("---------------------");
        graph.dfs(0);
    }
}
