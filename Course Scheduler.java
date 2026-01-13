//Optimised Solution

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, graph, visited, onPath)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int course, List<Integer>[] graph,
                             boolean[] visited, boolean[] onPath) {

        if (onPath[course]) return true;
        if (visited[course]) return false;

        visited[course] = true;
        onPath[course] = true;

        for (int prereq : graph[course]) {
            if (hasCycle(prereq, graph, visited, onPath)) {
                return true;
            }
        }

        onPath[course] = false;
        return false;
    }
}


//Brute Force Solution
class Solution {
    public void cal_Indegree(List<List<Integer>> adj, int[] indegree) {
        for (int u = 0; u < adj.size(); u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); // prereq -> course
        }
        
        int[] indegree = new int[numCourses];
        cal_Indegree(adj, indegree);

        // Topological sort using BFS (Kahn's Algorithm)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If not all courses are in the result, there's a cycle
        if (ans.size() != numCourses) {
            return new int[0];
        }

        // Convert result to int array
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
