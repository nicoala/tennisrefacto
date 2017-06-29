public class TennisGame3 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame3(String namePlayerOne, String namePlayerTwo) {
        playerOne = new Player(namePlayerOne, 0);
        playerTwo = new Player(namePlayerTwo, 0);
    }

    public String getScore() {
        if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return onePlayerIsCloseToWin();
        } else {
            return gameBeforeFirstTie();
        }
    }

    private String gameBeforeFirstTie() {
        if (playersTiedForFirstTime()) {
            return TennisScore.DEUCE.toString();
        } else {
            return formatGameScore();
        }
    }

    private String onePlayerIsCloseToWin() {
        if (playersTied()) {
            return TennisScore.DEUCE.toString();
        }
        return playerOne.gameOnTheLineVs(playerTwo);
    }

    private boolean playersTied() {
        return playerOne.hasSameScore(playerTwo);
    }

    private boolean playersTiedForFirstTime() {
        return playerOne.hasSameScore(playerTwo) && playerOne.isCloseToEndOfGame();
    }

    private String formatGameScore() {
        if (playerOne.hasSameScore(playerTwo)) {
            return playerOne.tennisScore() + "-All";
        } else {
            return playerOne.tennisScore() + "-" + playerTwo.tennisScore();
        }
    }

    public void wonPoint(String playerName) {
        if (playerOne.isNamed(playerName)) {
            playerOne.scores();
        } else {
            playerTwo.scores();
        }

    }

}
