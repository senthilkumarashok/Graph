interface Graph<T> {
   
  boolean addVertex(T t);
  void addEdge(T t1, T t2);
  void dfs();  
  void bfs();
}
