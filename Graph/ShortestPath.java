import java.util.*;
import java.lang.*;
import java.io.*;
 
public class ShortestPath {
	private static Graph.Edge[] GRAPH = {
		new Graph.Edge("a", "b", 7),
		new Graph.Edge("b", "a", 7),
		new Graph.Edge("a", "c", 9),
		new Graph.Edge("c", "a", 9),
		new Graph.Edge("a", "f", 14),
		new Graph.Edge("f", "a", 14),
		new Graph.Edge("b", "c", 10),
		new Graph.Edge("c", "b", 10),
		new Graph.Edge("b", "d", 15),
		new Graph.Edge("d", "b", 15),
		new Graph.Edge("c", "d", 11),
		new Graph.Edge("d", "c", 11),
		new Graph.Edge("c", "f", 2),
		new Graph.Edge("f", "c", 2),
		new Graph.Edge("d", "e", 6),
		new Graph.Edge("e", "d", 6),
		new Graph.Edge("e", "f", 9),
		new Graph.Edge("f", "e", 9),
		new Graph.Edge("a", "g", 5),
		new Graph.Edge("g", "a", 5),
		new Graph.Edge("g", "h", 8),
		new Graph.Edge("h", "g", 8),
		new Graph.Edge("f", "i", 3),
		new Graph.Edge("i", "f", 3),
		new Graph.Edge("c", "j", 10),
		new Graph.Edge("j", "c", 10),
		new Graph.Edge("j", "h", 7),
		new Graph.Edge("h", "j", 7),
		new Graph.Edge("a", "i", 11),
		new Graph.Edge("a", "a", 11),
	};

	public static void main(String[] args) {
		Graph g = new Graph(GRAPH);
		System.out.println("Running dijkstra algorithm on the given graph");
		System.out.println("Starting node is -> 'a'");
		System.out.println("Printing Shortest Paths to each Vertex");
		g.dijkstraRun("a");
		g.printAllPaths();
	}
}

class Graph {
	private final Map<String, Vertex> graph;
	public static class Edge {
		public int dist;
		public String v1, v2;
		public Edge(String vertex1, String vertex2, int dist) {
			this.dist = dist;
			this.v1 = vertex1;
			this.v2 = vertex2;
		}
	}

	public static class Vertex implements Comparable<Vertex> {
		public final String name;
		public Vertex previous = null;
		public int dist = Integer.MAX_VALUE;
		public final Map<Vertex, Integer> adjacentVertices = new HashMap<>();

		public Vertex(String name) {
			this.name = name;
		}

		private void printPath() {
			if (this == this.previous) {
				System.out.printf("%s", this.name);
			} else if (this.previous == null) {
				System.out.printf("%s(X)", this.name);
			} else {
				this.previous.printPath();
				System.out.printf(" --> %s(%d)", this.name, this.dist);
			}
		}

		public int compareTo(Vertex ob) {
			if (dist == ob.dist) {
				return name.compareTo(ob.name);
			} 
			return Integer.compare(dist, ob.dist);
		}

		public String toString() {
			return "(" + name + ", " + dist + ")";
		}
	}

	public Graph(Edge[] edges) {
		graph = new HashMap<>(edges.length);

		for (Edge e : edges) {
			if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
			if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
		}

		for (Edge e : edges) {
			graph.get(e.v1).adjacentVertices.put(graph.get(e.v2), e.dist);
		}
	}

	public void printPath(String destination) {
		graph.get(destination).printPath();
		System.out.println();
	}

	public void printAllPaths() {
		for (Vertex v : graph.values()) {
			v.printPath();
			System.out.println();
		}
	}

	public void dijkstraRun(String startNode) {
		final Vertex source = graph.get(startNode);
		NavigableSet<Vertex> q = new TreeSet<>();

		for (Vertex v : graph.values()) {
			v.previous = v == source ? source : null;
			v.dist = v == source ? 0 : Integer.MAX_VALUE;
			q.add(v);
		}

		dijkstraRun(q);
	}

	private void dijkstraRun(final NavigableSet<Vertex> q) {      
		Vertex u, v;
		while (!q.isEmpty()) {
			u = q.pollFirst();
			if (u.dist == Integer.MAX_VALUE) {
				break;
			}
			for (Map.Entry<Vertex, Integer> a : u.adjacentVertices.entrySet()) {
				v = a.getKey();

				final int minDist = u.dist + a.getValue();
				if (minDist < v.dist) {
					q.remove(v);
					v.dist = minDist;
					v.previous = u;
					q.add(v);
				} 
			}
		}
	}
}
