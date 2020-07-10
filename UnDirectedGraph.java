import java.util.*;

class UnDirectedGraph<T> implements Graph<T> {

    private Set<Vertex> vertices;
    private Map<T, Vertex> idToVertextMap;

    public UnDirectedGraph() {
        this.vertices = new LinkedHashSet<>();
        this.idToVertextMap = new HashMap<>();
    }

    public boolean addVertex(T t) {
        if(hasVertex(t)) return false;
        Vertex vertex = new Vertex(t);
        vertices.add(vertex);
        idToVertextMap.put(t, vertex);
        return false;
    }

    public void addEdge(T u, T v) {
        addVertex(u); 
        addVertex(v);         
        idToVertextMap.get(u).adjacents.add(idToVertextMap.get(v));
        idToVertextMap.get(v).adjacents.add(idToVertextMap.get(u));        
    }

    public void dfs() {        
        List<T> output = new LinkedList<>();
        int i = 0;
        Stack<Vertex> stack = new Stack();
        Map<T, Boolean> vertexIdToVisitedMap = new HashMap<>();
        stack.push(vertices.iterator().next());
        while(!stack.isEmpty()) {
            Vertex<T> vertex = stack.pop();
            if(!vertexIdToVisitedMap.getOrDefault(vertex.id, Boolean.FALSE)) {
                vertexIdToVisitedMap.put(vertex.id, Boolean.TRUE);                
                output.add(vertex.id);
                for(Vertex adjacentVertex : vertex.adjacents) {                
                    if(!vertexIdToVisitedMap.getOrDefault(adjacentVertex.id, Boolean.FALSE)) {
                        // System.out.println("Adding to stack for vertex: " + vertex.id + " adjacent: " + adjacentVertex.id);
                        stack.push(adjacentVertex);                    
                    }
                }
            }
        }
        System.out.println("DFS Output : "+ output);
    }

    public void bfs() {
        List<T> output = new LinkedList<>();
        Map<T, Boolean> vertexIdToVisitedMap = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertices.iterator().next());
        while(!queue.isEmpty()) {
            Vertex<T> vertex = queue.poll();
            if(!vertexIdToVisitedMap.getOrDefault(vertex.id, Boolean.FALSE)) {
                vertexIdToVisitedMap.put(vertex.id, Boolean.TRUE);                
                output.add(vertex.id);
                for(Vertex adjacentVertex : vertex.adjacents) {                
                    if(!vertexIdToVisitedMap.getOrDefault(adjacentVertex.id, Boolean.FALSE)) {
                        // System.out.println("Adding to stack for vertex: " + vertex.id + " adjacent: " + adjacentVertex.id);
                        queue.add(adjacentVertex);                    
                    }
                }
            }
        }
        System.out.println("BFS Output : "+output);
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
            return "Vertex with id : "+ id + " adjacents : "+ adjacents.size();
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