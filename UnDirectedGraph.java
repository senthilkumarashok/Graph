import java.util.*;

class UnDirectedGraph implements Graph {

    private Set<Vertex> vertices;
    private Map<Integer, Vertex> idToVertextMap;

    public UnDirectedGraph() {
        this.vertices = new HashSet<>();
        this.idToVertextMap = new HashMap<>();
    }

    public void addVertex(int t) {
        Vertex vertex = new Vertex(t);
        vertices.add(vertex);
        idToVertextMap.put(Integer.valueOf(t), vertex);
    }

    public void addEdge(int u, int v) {
        if(!hasVertex(u)) { 
            addVertex(u); 
        }
        if(!hasVertex(v)) { 
            addVertex(v); 
        }
        idToVertextMap.get(u).adjacents.add(idToVertextMap.get(v));
        idToVertextMap.get(v).adjacents.add(idToVertextMap.get(u));        
    }

    public void dfs() {

    }

    public void bfs() {

    }

    public boolean hasVertex(int v) {        
        return vertices.contains(idToVertextMap.get(v));
    }

    private class Vertex {
        private int id;
        Set<Vertex> adjacents;
        public Vertex(int id) {
            this.id = id;
            this.adjacents = new LinkedHashSet<>();
        }        
    }
}