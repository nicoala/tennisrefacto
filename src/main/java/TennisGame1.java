public class TennisGame1 implements TennisGame {

    public static final String ALL_PLAYERS_HAVE_SAME_SCORE = "-All";
    private Player playerOne;
    private Player playerTwo;

    TennisGame1(String playerOneName, String playerTwoName) {

        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);

    }

    public void wonPoint(String playerName) {
        if (playerOne.isNamed(playerName)) {
            playerOne.scores();
        } else {
            playerTwo.scores();
        }
    }

    public String getScore() {
        String score = "";

        if (playerOne.hasSameScore(playerTwo)) {
            return playersHaveSameScore(score);
        } else if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            return playerOne.gameOnTheLineVs(playerTwo);
        } else {
            return formatGameScore(score);
        }
    }

    private String playersHaveSameScore(String score) {

        if (playerOne.isCloseToEndOfGame()) {
            return TennisScore.DEUCE.toString();
        } else {
            return calculateScore(score, playerOne) + ALL_PLAYERS_HAVE_SAME_SCORE;
        }
    }

    private String formatGameScore(String score) {
        return calculateScore(score, playerOne) + "-" + calculateScore(score, playerTwo);

    }

    private String calculateScore(String score, Player player) {
        return score + player.tennisScore();
    }

}
