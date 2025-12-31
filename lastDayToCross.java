/*
There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
*/


class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = row * col;
        int top = n, bottom = n + 1;

        int[] parent = new int[n + 2];
        int[] rank = new int[n + 2];
        boolean[][] grid = new boolean[row][col];

        for (int i = 0; i < n + 2; i++) parent[i] = i;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int d = n - 1; d >= 0; d--) {
            int r = cells[d][0] - 1;
            int c = cells[d][1] - 1;
            grid[r][c] = true;
            int id = r * col + c;

            if (r == 0) union(id, top, parent, rank);
            if (r == row - 1) union(id, bottom, parent, rank);

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc]) {
                    union(id, nr * col + nc, parent, rank);
                }
            }

            if (find(top, parent) == find(bottom, parent)) return d;
        }
        return 0;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] rank) {
        a = find(a, parent);
        b = find(b, parent);
        if (a == b) return;
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
    }
}
