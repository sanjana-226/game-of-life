package rules;

public class StandardGameRules implements GameRules {

    static int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    @Override
    public int computeNextState(int currentState, int neighboursCount) {

        if ((currentState & 1) == 1) { //currently alive
            if (neighboursCount == 2 || neighboursCount == 3) {
                return currentState | 2; // stay alive
            }
        } else { // currently dead
            if (neighboursCount == 3) {
                return currentState | 2; // become alive
            }
        }
        return currentState;
    }

    @Override
    public int[][] getDirections() {
        return DIRECTIONS;
    }


}
