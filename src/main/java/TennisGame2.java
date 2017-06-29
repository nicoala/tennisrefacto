public class TennisGame2 implements TennisGame
{
    private Player playerOne;
    private Player playerTwo;

    TennisGame2(String player1Name, String player2Name) {
        playerOne = new Player(player1Name, 0);
        playerTwo = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        Score.aPlayerScores(playerName, playerOne, playerTwo);
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
            return Score.playersTiedAt(playerOne.tennisScore());
        }
    }

    private String notADraw() {
        if (playerOne.isAboutToWin() || playerTwo.isAboutToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return Score.format(playerOne, playerTwo);
        }
    }
}