public class TennisGame2 implements TennisGame
{
    String score = "";

    Player playerOne;
    Player playerTwo;

    public TennisGame2(String player1Name, String player2Name) {

        playerOne = new Player(player1Name, 0);
        playerTwo = new Player(player2Name, 0);
    }

    public String getScore(){

        if (playerOne.hasSameScore(playerTwo) && !playerOne.isCloseToWin())
        {
            score = playerOne.tennisScore();
            score += "-All";
        }

        if (playerOne.hasSameScore(playerTwo) && playerOne.isCloseToEndOfGame()) {

            score = TennisScore.DEUCE.toString();
        }

        if(!playerOne.hasSameScore(playerTwo)) {

            if ( playerOne.isCloseToWin() || playerTwo.isCloseToWin()) {
                score = playerOne.gameOnTheLineVs(playerTwo);
            } else {
                score = playerOne.tennisScore() + "-" + playerTwo.tennisScore();
            }
        }

        return score;
    }

    public void P1Score(){
        playerOne.scores();
    }

    public void P2Score(){
        playerTwo.scores();
    }

    public void wonPoint(String player) {
        if (playerOne.isNamed(player))
            P1Score();
        else
            P2Score();
    }
}