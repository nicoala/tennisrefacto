public class TennisGame3 implements TennisGame {

    private int pointsPlayerTwo;
    private int pointsPlayerOne;
    private Player playerOne;
    private Player playerTwo;

    public TennisGame3(String namePlayerOne, String namePlayerTwo) {
        playerOne = new Player(namePlayerOne, 0);
        playerTwo = new Player(namePlayerTwo, 0);
    }

    public String getScore() {
        String score;

        if (pointsPlayerOne < 4 && pointsPlayerTwo < 4 && !(pointsPlayerOne + pointsPlayerTwo == 6)) {

            score = playerOne.tennisScore();
            return (playerOne.hasSameScore(playerTwo)) ? score + "-All" : score + "-" + playerTwo.tennisScore();

        } else {
            if (playerOne.hasSameScore(playerTwo)) {
                return TennisScore.DEUCE.toString();
            }
            return playerOne.gameOnTheLineVs(playerTwo);
        }
    }

    public void wonPoint(String playerName) {
        if (playerOne.isNamed(playerName)) {
            playerOne.scores();
            this.pointsPlayerOne++;
        } else {
            playerTwo.scores();
            this.pointsPlayerTwo++;
        }

    }

}
