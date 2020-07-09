class Main {

    public static void main(String[] args) {
        Graph g = new UnDirectedGraph();
        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addVertex(4);
        g.addEdge(4,2);
        g.dfs();
    }
}