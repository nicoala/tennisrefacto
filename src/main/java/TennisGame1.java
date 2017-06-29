public class TennisGame1 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    private static final String ALL_PLAYERS_HAVE_SAME_SCORE = "-All";

    TennisGame1(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);
    }

    public String getScore() {
        if (playerOne.hasSameScore(playerTwo)) {
            return playersHaveSameScore();
        } else if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return formatGameScore();
        }
    }

    public void wonPoint(String playerName) {
        if (playerOne.isNamed(playerName)) {
            playerOne.scores();
        } else {
            playerTwo.scores();
        }
    }

    private String playersHaveSameScore() {
        if (playerOne.isCloseToEndOfGame()) {
            return TennisScore.DEUCE.toString();
        } else {
            return playerOne.tennisScore() + ALL_PLAYERS_HAVE_SAME_SCORE;
        }
    }

    private String formatGameScore() {
        return playerOne.tennisScore() + "-" + playerTwo.tennisScore();

    }

}
