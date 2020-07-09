import java.util.*;

class UnDirectedGraph implements Graph {

    private Set<Vertex> vertices;
    private Map<Integer, Vertex> idToVertextMap;

    public UnDirectedGraph() {
        this.vertices = new LinkedHashSet<>();
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
        System.out.println("Traversing Graph through DFS");
        Stack<Vertex> stack = new Stack();
        Map<Integer, Boolean> vertexIdToVisitedMap = new HashMap<>();
        stack.push(vertices.iterator().next());
        while(!stack.isEmpty()) {
            Vertex vertex = stack.pop();
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