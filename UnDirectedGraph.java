import java.util.*;

class UnDirectedGraph<T> implements Graph<T> {

    private Set<Vertex> vertices;
    private Map<T, Vertex> idToVertextMap;

    public UnDirectedGraph() {
        this.vertices = new LinkedHashSet<>();
        this.idToVertextMap = new HashMap<>();
    }

    public void addVertex(T t) {
        Vertex vertex = new Vertex(t);
        vertices.add(vertex);
        idToVertextMap.put(t, vertex);
    }

    public void addEdge(T u, T v) {
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
        System.out.println("Traversing Graph through DFS");
        Stack<Vertex> stack = new Stack();
        Map<T, Boolean> vertexIdToVisitedMap = new HashMap<>();
        stack.push(vertices.iterator().next());
        while(!stack.isEmpty()) {
            Vertex<T> vertex = stack.pop();
            vertexIdToVisitedMap.put(vertex.id, Boolean.TRUE);
            System.out.println(vertex);
            for(Vertex adjacentVertex : vertex.adjacents) {                
                if(!vertexIdToVisitedMap.getOrDefault(adjacentVertex.id, Boolean.FALSE)) {
                    stack.push(adjacentVertex);
                }
            }
        }
    }

    public void bfs() {

    }

    public boolean hasVertex(T v) {        
        return vertices.contains(idToVertextMap.get(v));
    }

    private class Vertex<T> {
        private T id;
        Set<Vertex> adjacents;

        public Vertex(T id) {
            this.id = id;
            this.adjacents = new LinkedHashSet<>();
        }
        public String toString() {
            return "Vertex with id : "+ id;
        }        
    }

    private class Edge {
        private Vertex sourceVertex;
        private Vertex targetVertex;

        public Edge(int sourceId, Vertex targetId) {
            this.sourceVertex = sourceVertex;
            this.targetVertex = targetVertex;
        }
    }
}