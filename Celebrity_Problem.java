class Celebrity_Problem {
    public int celebrity(int[][] M) {
        int n = M.length;
        int candidate = 0;

        // Find the candidate
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                // Candidate knows i, so candidate cannot be celebrity
                candidate = i;
            }
            // else, i cannot be celebrity
        }

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    // Candidate knows someone, or someone doesn't know candidate
                    return -1;
                }
            }
        }

        return candidate;
    }
}
