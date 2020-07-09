import java.util.

class UnDirectedGraph<T> implements Graph<T> {

    private class Vertex {
        private int id;
        public Vertex(int id) {
            this.t = t;
            this.adjacents = new LinkedHashSet<>();
        }

        List<Vertex> adjacents;
    }

    private Set<Vertex> vertices;
    private Map<Integer, Vertex> lookUp;

    public UnDirectedGraph() {
        this.vertices = new HashSet<>();
        this.lookUp = new HashMap<>();
    }

    public void addVertex(int t) {
        Vertex vertex = new Vertex<>(t);
        vertices.add(vertex);
        lookUp.put(Integer.valueOf(int), vertex);
    }

    public void addEdge(int u, int v) {
        Vertex vertex1 = lookUp.get(u);
        Vertex vertex2 = lookUp.get(u);
        if(!hasVertex(u)) { 
            vertex1 = addVertex(u); 
        }
        if(!hasVertex(v)) { 
            vertex2 = addVertex(v); 
        }
        vertex1.adjacents.add(vertex2);
        vertex2.adjacents.add(vertex1);
        
    }

    public void dfs() {

    }

    public void bfs() {

    }

    public boolean hasVertex(T v) {        
        return vertices.contains(lookUp.get(v));
    }
}