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
            score = playersHaveSameScore(score);
        } else if (playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
            score = playerOne.gameOnTheLineVs(playerTwo);
        } else {
            score = formatGameScore(score);
        }

        return score;
    }

    private String playersHaveSameScore(String score) {

        if (playerOne.isCloseToEndOfGame()) {
            score = TennisScore.DEUCE.toString();
        } else {
            score = calculateScore(score, playerOne);
            score += ALL_PLAYERS_HAVE_SAME_SCORE;
        }

        return score;
    }

    private String formatGameScore(String score) {

        score = calculateScore(score, playerOne);
        score += "-";
        return calculateScore(score, playerTwo);

    }

    private String calculateScore(String score, Player player) {
        score += player.tennisScore();
        return score;
    }

}
