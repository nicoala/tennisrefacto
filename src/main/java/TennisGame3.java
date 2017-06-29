public class TennisGame3 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    TennisGame3(String namePlayerOne, String namePlayerTwo) {
        playerOne = new Player(namePlayerOne, 0);
        playerTwo = new Player(namePlayerTwo, 0);
    }

    public String getScore() {
        if (playerOne.isAboutToWin() || playerTwo.isAboutToWin()) {
            return onePlayerIsCloseToWin();
        } else {
            return gameBeforeFirstTie();
        }
    }

    private String gameBeforeFirstTie() {
        if (playerOne.hasSameScore(playerTwo) && playerOne.isCloseToEndOfGame()) {
            return Score.deuce();
        } else {
            return formatGameScore();
        }
    }

    private String onePlayerIsCloseToWin() {
        if (playerOne.hasSameScore(playerTwo)) {
            return Score.deuce();
        }
        return playerOne.gameOnTheLineVs(playerTwo);
    }

    private String formatGameScore() {
        if (playerOne.hasSameScore(playerTwo)) {

            return Score.playersTiedAt(playerOne.tennisScore());
        } else {
            return Score.format(playerOne, playerTwo);
        }
    }

    public void wonPoint(String playerName) {
        Score.aPlayerScores(playerName, playerOne, playerTwo);
    }
}
