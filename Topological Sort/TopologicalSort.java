import java.util.*;
import java.lang.*;
import java.io.*;

public class TopologicalSort {
    private int Vertices;
    private LinkedList<Integer> adjacencyList[];

    TopologicalSort(int vertices) {
        this.Vertices = vertices;
        adjacencyList = new LinkedList[this.Vertices];

        for (int i = 0; i < this.Vertices; i++) {
            adjacencyList[i] = new LinkedList();
        }
    }

    void addEdge(int v1, int v2) {
        adjacencyList[v1].add(v2);
    }

    void printGraph() {
        Iterator<Integer> it;
        Integer vertex;
        for (int i = 0; i < Vertices; i++) {
            it = adjacencyList[i].iterator();
            while (it.hasNext()) {
                vertex = it.next();
                System.out.println(i + " -> " + vertex);
            }

        }
    }

    void topologicalOrdering() {
        Stack stack = new Stack();
        boolean visited[] = new boolean[Vertices];
        for (int i = 0; i < Vertices; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < Vertices; i++) {
            if (visited[i] == false) {
                dfs(visited, i, stack);
            }
        }

        if (stack.empty() == false) {
            while (stack.empty() == false) {
                System.out.print(stack.pop() + " -> ");
            }
            System.out.print("null");
        }
    }

    void dfs(boolean visited[], int v, Stack stack) {
        visited[v] = true;
        Integer idx;
        Iterator<Integer> it = adjacencyList[v].iterator();
        while (it.hasNext()) {
            idx = it.next();
            if (visited[idx] == false) {
                dfs(visited, idx, stack);
            }
        }
        stack.push(new Integer(v));
    }

    private boolean dfs(int i, boolean[] visited, boolean[] stack) {
        if (stack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        List<Integer> neighbors = adjacencyList[i];
        visited[i] = true;
        stack[i] = true;

        for (Integer v: neighbors) {
            if (dfs(v, visited, stack)) {
                return true;
            }
        }
        stack[i] = false;

        return false;
    }

    private boolean checkCycle() {
        boolean[] visited = new boolean[Vertices];
        boolean[] stack = new boolean[Vertices];

        for (int i = 0; i < Vertices; i++) {
            if (dfs(i, visited, stack)) {
                System.out.println("The given graph contains cycle. Printing the edges in the cycle");
                for (int j = 0; j < stack.length; j++) {
                    if (stack[j] == true) {
                        System.out.print(j + " -> ");
                    }
                }
                System.out.println();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(10);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 8);
        graph.addEdge(6, 7);
        graph.addEdge(5, 7);
        graph.addEdge(7, 9);
        graph.addEdge(5, 9);
        graph.addEdge(8, 9);
        graph.addEdge(9, 0);
        graph.addEdge(8, 0);

        System.out.println("Running code for printing topological ordering");
        System.out.println("The edges of the graph is as follows : ");
        graph.printGraph();

        System.out.println("The vertices of graph in topological order is : ");
        graph.topologicalOrdering();

        graph = new TopologicalSort(10);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(7, 9);
        graph.addEdge(4, 8);
        graph.addEdge(3, 5);
        graph.addEdge(5, 8);
        graph.addEdge(5, 9);

        System.out.println("\nRunning code to find cycles in graph using topological ordering");
        System.out.println("The edges of the graph is as follows : ");
        graph.printGraph();

        if (!graph.checkCycle()) {
            System.out.println("Graph doesn't "+ "contain cycle");
            System.out.println("The vertices of graph in topological order is : ");
            graph.topologicalOrdering();
        }
    }
}
