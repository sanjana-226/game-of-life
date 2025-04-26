package engine;

import board.Board;
import rules.GameRules;

public class EvolutionEngine {

    private final GameRules gameRules;

    public EvolutionEngine(GameRules gameRules) {
        this.gameRules = gameRules;
    }

    public void evolve(Board board) {
        int[][] grid = board.getGrid();
        int m = board.getRowCount();
        int n = board.getColCount();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int aliveNeighbors = countAliveNeighbors(grid, i, j, m, n);
                grid[i][j] = gameRules.computeNextState(grid[i][j], aliveNeighbors);
            }
        }
        applyNextState(grid, m, n);
    }

    private void applyNextState(int[][] grid, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] >>= 1;
            }
        }
    }

    private int countAliveNeighbors(int[][] grid, int x, int y, int m, int n) {
        int count = 0;
        int[][] directions = gameRules.getDirections();
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                count += (grid[newX][newY] & 1);
            }
        }
        return count;
    }
}
