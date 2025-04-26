package board;

public class GliderBoardGenerator implements BoardGenerator {
    @Override
    public int[][] generateBoard(int rows, int cols) {
        int[][] grid = new int[rows][cols];
        int midRow = rows / 3;
        int midCol = cols / 3;

        grid[midRow][midCol + 1] = 1;
        grid[midRow + 1][midCol + 2] = 1;
        grid[midRow + 2][midCol] = 1;
        grid[midRow + 2][midCol + 1] = 1;
        grid[midRow + 2][midCol + 2] = 1;
        return grid;
    }
}
