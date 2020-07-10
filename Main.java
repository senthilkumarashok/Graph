class Main {

    public static void main(String[] args) {
        Graph g = new UnDirectedGraph();
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(2,6);
        g.addEdge(8,7);
        g.addEdge(8,4);
        g.addEdge(8,5);
        g.addEdge(8,6);
        g.addEdge(7,3);
        g.dfs();
        g.bfs();
    }
}