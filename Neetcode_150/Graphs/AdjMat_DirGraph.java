//Adjacency Matrix for Directed graph
import java.util.*;

class Solution {
    public static void adjmatrix() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int e = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, 0));
            adj.add(row);
        }

        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u - 1).set(v - 1, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj.get(i).get(j));
                if (j + 1 < n) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Solution.adjmatrix();
    }
}
*/
//Adjacency list for Directed Graph
import java.util.*;

public class Solution {
    public List<List<Integer>> adjList() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int E = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
        }

        return adj;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> adj = sol.adjList();

        for (int i = 1; i < adj.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
*/
