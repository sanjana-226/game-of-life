package rules;

public interface GameRules {
    int computeNextState(int currentState, int neighboursCount);

    int[][] getDirections();
}
