import java.util.*;
public class BellmanFordExp3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int v = scanner.nextInt();
        int[][] graph = new int[v][v];
        int[] dist = new int[v];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++) {
                graph[i][j] = scanner.nextInt();
                if (i != j && graph[i][j] == 0) graph[i][j] = 999;
            }
        System.out.println("Enter the source vertex:");
        int source = scanner.nextInt() - 1;
        Arrays.fill(dist, 999);
        dist[source] = 0;
        for (int k = 0; k < v - 1; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    if (dist[i] + graph[i][j] < dist[j])
                        dist[j] = dist[i] + graph[i][j];
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++)
                if (dist[i] + graph[i][j] < dist[j]) {
                    System.out.println("The Graph contains a negative edge cycle");
                    return;
                }
        for (int i = 0; i < v; i++)
            System.out.println("Distance from source " + (source + 1) + " to " + (i + 1) + " is " + dist[i]);
    }
}