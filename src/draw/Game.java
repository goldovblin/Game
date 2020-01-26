package draw;

public class Game {
    public static int playerPoints;
    public static int computerPoints;

    static {
        Round.putBalls(playerPoints, computerPoints);
    }

    //TODO: переосмыслить c Артемием
    static Result step() {
        Result roundResult = Round.step();
        if (roundResult != null) {
            if (roundResult == Result.PLAYER_WIN) {
                playerPoints++;
                if (playerPoints + computerPoints == Constants.cellsCount - 1) {
                    computerPoints--;
                }
            }
            if (roundResult == Result.COMPUTER_WIN) {
                computerPoints++;
                if (playerPoints + computerPoints == Constants.cellsCount - 1) {
                    playerPoints--;
                }
            }
            if (playerPoints == -1 || computerPoints == -1) {
                return roundResult;
            }
            Round.putBalls(playerPoints, computerPoints);
        }
        return null;
    }

    public enum Result {
        PLAYER_WIN, COMPUTER_WIN, DRAW
    }
}
