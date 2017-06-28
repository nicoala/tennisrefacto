public class TennisGame1 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame1(String playerOneName, String playerTwoName) {

        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);

    }

    public void wonPoint(String playerName) {
        if (playerOne.isItsName(playerName)) {
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

            score = playerOne.closeGame(playerTwo);

        } else {
            score = formatScore(score);
        }

        return score;
    }

    private String playersHaveSameScore(String score) {

        if (playerOne.getScore() >= 3) {
            score = "Deuce";
        } else {
            score = calculateScore(score, playerOne.getScore());
            score += "-All";
        }

        return score;
    }

    private String formatScore(String score) {
        score = calculateScore(score, playerOne.getScore());
        score += "-";
        return calculateScore(score, playerTwo.getScore());
    }

    private String calculateScore(String score, int playerScore) {

        switch(playerScore) {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }

        return score;
    }
}
