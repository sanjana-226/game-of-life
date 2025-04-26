package board;

import lombok.Getter;

@Getter

public class Board {
    private int rowCount;
    private int colCount;
    private int[][] grid;

    public Board(int rowCount, int colCount, BoardGenerator generator) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.grid = generator.generateBoard(rowCount, colCount);

    }

    public void printBoard() {
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                System.out.print(grid[r][c] == 1 ? "⬜" : "⬛");
            }
            System.out.println();
        }
        System.out.println("-".repeat(colCount));
    }
}
