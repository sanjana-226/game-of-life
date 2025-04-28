import board.BoardGenerator;
import board.GliderBoardGenerator;
import rules.GameRules;
import rules.StandardGameRules;

public class Main {
    private static final int BOARD_ROWS = 15;
    private static final int BOARD_COLS = 15;
    private static final int TICKS = 10;

    public static void main(String[] args) {
        GameRules gameRules = new StandardGameRules();
        BoardGenerator boardGenerator=new GliderBoardGenerator();
        Game game = new Game(BOARD_ROWS, BOARD_COLS, TICKS,gameRules,boardGenerator);
        game.start();
    }
}
