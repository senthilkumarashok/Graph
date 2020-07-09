class Main {

    public static void main(String[] args) {
        Graph g = new UnDirectedGraph();
        g.add(2,3);
        g.add(1,3);
        g.dfs();
    }
}