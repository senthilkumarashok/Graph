class Main {

    public static void main(String[] args) {
        Graph g = new UnDirectedGraph();
        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("A","D");
        g.addEdge("B","E");
        g.addEdge("B","F");
        g.addEdge("H","G");
        g.addEdge("H","D");
        g.addEdge("H","E");
        g.addEdge("H","F");
        g.addEdge("G","C");
        g.dfs();
        g.bfs();
    }
}