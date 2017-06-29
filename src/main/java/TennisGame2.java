public class TennisGame2 implements TennisGame
{
    private Player playerOne;
    private Player playerTwo;

    TennisGame2(String player1Name, String player2Name) {
        playerOne = new Player(player1Name, 0);
        playerTwo = new Player(player2Name, 0);
    }

    public void wonPoint(String player) {
        if (playerOne.isNamed(player)) {
            playerOne.scores();
        } else {
            playerTwo.scores();
        }
    }

    public String getScore(){
        if(playerOne.hasSameScore(playerTwo)) {
            return closeGameIsTied();
        } else {
            return notADraw();
        }
    }

    private String closeGameIsTied() {
        if (playerOne.isCloseToEndOfGame()) {
            return Score.deuce();
        } else {
            return gameIsTied();
        }
    }

    private String gameIsTied() {
        return Score.playersTiedAt(playerOne.tennisScore());
    }

    private String notADraw() {
        if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return Score.format(playerOne, playerTwo);
        }
    }
}