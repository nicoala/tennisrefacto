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
        } else if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return formatGameScore();
        }
    }

    public void wonPoint(String playerName) {
        aPlayerHasScored(playerName, playerOne);
        aPlayerHasScored(playerName, playerTwo);
    }

    private void aPlayerHasScored(String playerName, Player player) {
        if(player.isNamed(playerName))
            player.scores();
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