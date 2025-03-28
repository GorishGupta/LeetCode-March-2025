import java.util.*;

class DS2503 {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int n = queries.length;
        int[] result = new int[n];
        int[][] visited = new int[rows][cols];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]> sortedQueries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sortedQueries.add(new int[] { queries[i], i });
        }
        sortedQueries.sort(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = 1;
        int points = 0;

        for (int[] q : sortedQueries) {
            int queryVal = q[0], queryIdx = q[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryVal) {
                int[] top = minHeap.poll();
                int row = top[1], col = top[2];
                points++;

                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
                        minHeap.offer(new int[] { grid[nr][nc], nr, nc });
                        visited[nr][nc] = 1;
                    }
                }
            }
            result[queryIdx] = points;
        }
        return result;
    }

    public static void main(String[] args) {
        DS2503 ds = new DS2503();
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] queries = { 5, 10, 15 };
        int[] result = ds.maxPoints(grid, queries);
        System.out.println(Arrays.toString(result)); // Output: [5, 8, 9]
        // Example output, adjust based on your grid and queries
    }
}