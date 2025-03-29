

// User function Template for Java

class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        
        int visited[][] = new int[m][n];
        
         Set<Set<List<Integer>>> ans = new HashSet<>();
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    Set<List<Integer>> set = new HashSet<>();
                    BFS(grid,visited,set,i,j);
                    ans.add(set);
                }
                
            }
        }
        return ans.size();
    }
    public void BFS(int grid[][], int visited[][], Set<List<Integer>> set, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j] = 1;
        
        
        int ri = i;
        int cj = j;
        
        while(!q.isEmpty()){
            Pair node = q.remove();
            int first = node.first;
            int second = node.second;
            
            
            set.add(Arrays.asList(first-ri,second-cj));
            
            
            
            // Right
            if (second < n - 1 && grid[first][second + 1] == 1 && visited[first][second + 1] == 0) {
                q.add(new Pair(first, second + 1));
                visited[first][second + 1] = 1;
            }

            // Left
            if (second > 0 && grid[first][second - 1] == 1 && visited[first][second - 1] == 0) {
                q.add(new Pair(first, second - 1));
                visited[first][second - 1] = 1;
            }

            // Down
            if (first < m - 1 && grid[first + 1][second] == 1 && visited[first + 1][second] == 0) {
                q.add(new Pair(first + 1, second));
                visited[first + 1][second] = 1;
            }

            // Up
            if (first > 0 && grid[first - 1][second] == 1 && visited[first - 1][second] == 0) {
                q.add(new Pair(first - 1, second));
                visited[first - 1][second] = 1;
            }
        }
    }
}
