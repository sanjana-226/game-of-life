import board.Board;
import board.BoardGenerator;
import engine.EvolutionEngine;
import rules.GameRules;

public class Game {
    private final int boardRows;
    private final int boardCols;
    private final int ticks;
    private final GameRules gameRules;
    private final BoardGenerator boardGenerator;

    public Game(int boardRows, int boardCols, int ticks, GameRules gameRules, BoardGenerator boardGenerator) {
        this.boardRows = boardRows;
        this.boardCols = boardCols;
        this.ticks = ticks;
        this.gameRules = gameRules;
        this.boardGenerator = boardGenerator;
    }

    public void start() {
        Board board = createBoard(boardGenerator);
        EvolutionEngine engine = createEngine(gameRules);
        for (int i = 0; i < ticks; i++) {
            engine.evolve(board);
            board.printBoard();
        }
    }

    private Board createBoard(BoardGenerator boardGenerator) {
        return new Board(boardRows, boardCols, boardGenerator);
    }

    private EvolutionEngine createEngine(GameRules gameRules) {
        return new EvolutionEngine(gameRules);
    }
}

