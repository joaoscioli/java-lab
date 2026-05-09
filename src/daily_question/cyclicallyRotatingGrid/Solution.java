package daily_question.cyclicallyRotatingGrid;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int layers = Math.min(rows, cols) / 2;

        int[][] result = new int[rows][cols];

        for (int layer = 0; layer < layers; layer++) {
            List<int[]> positions = new ArrayList<>();

            int top = layer;
            int bottom = rows - 1 - layer;
            int left = layer;
            int right = cols - 1 - layer;

            for (int col = left; col <= right; col++) {
                positions.add(new int[]{top, col});
            }

            for (int row = top + 1; row <= bottom; row++) {
                positions.add(new int[]{row, right});
            }

            for (int col = right - 1; col >= left; col--) {
                positions.add(new int[]{bottom, col});
            }

            for (int row = bottom - 1; row > top; row--) {
                positions.add(new int[]{row, left});
            }

            int size = positions.size();
            int rotations = k % size;

            for (int i = 0; i < size; i++) {
                int[] from = positions.get((i + rotations) % size);
                int[] to = positions.get(i);

                result[to[0]][to[1]] = grid[from[0]][from[1]];
            }
        }

        return result;
    }
}
