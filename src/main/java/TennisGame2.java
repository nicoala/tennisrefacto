public class TennisGame2 implements TennisGame
{
    String score = "";

    Player playerOne;
    Player playerTwo;

    public TennisGame2(String player1Name, String player2Name) {
        playerOne = new Player(player1Name, 0);
        playerTwo = new Player(player2Name, 0);
    }

    public void wonPoint(String player) {
        if (playerOne.isNamed(player))
            playerOne.scores();
        else
            playerTwo.scores();
    }

    public String getScore(){

        if(playerOne.hasSameScore(playerTwo)) {
            score = closeGameIsTied();
        } else {
            score = notADraw();
        }
        return score;
    }

    private String closeGameIsTied() {
        if (playerOne.isCloseToEndOfGame()) {
            return TennisScore.DEUCE.toString();
        } else {
            return gameIsTied();
        }
    }

    private String gameIsTied() {
        String gameScore = playerOne.tennisScore();
        gameScore += "-All";
        return gameScore;
    }

    private String notADraw() {
        if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return playerOne.tennisScore() + "-" + playerTwo.tennisScore();
        }
    }
}