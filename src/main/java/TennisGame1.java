public class TennisGame1 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    TennisGame1(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);
    }

    public String getScore() {
        if (playerOne.hasSameScore(playerTwo)) {
            return playersHaveSameScore();
        } else if (playerOne.isAboutToWin() || playerTwo.isAboutToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return formatGameScore();
        }
    }

    public void wonPoint(String playerName) {
        Score.aPlayerScores(playerName, playerOne, playerTwo);
    }

    private String playersHaveSameScore() {
        if (playerOne.isCloseToEndOfGame()) {
            return Score.deuce();
        } else {
            return Score.playersTiedAt(playerOne.tennisScore());
        }
    }

    private String formatGameScore() {
        return Score.format(playerOne, playerTwo);

    }
}