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
            gameIsTied();
            closeGameIsTied();
        } else {
            score = notADraw();
        }
        return score;
    }

    private void gameIsTied() {
        score = playerOne.tennisScore();
        score += "-All";
    }

    private void closeGameIsTied() {
        if (playerOne.isCloseToEndOfGame()) {
            score = TennisScore.DEUCE.toString();
        }
    }

    private String notADraw() {
        if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return playerOne.tennisScore() + "-" + playerTwo.tennisScore();
        }
    }
}