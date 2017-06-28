public class TennisGame2 implements TennisGame
{
    String score = "";

    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";

    Player playerOne;
    Player playerTwo;

    public TennisGame2(String player1Name, String player2Name) {

        playerOne = new Player(player1Name, 0);
        playerTwo = new Player(player2Name, 0);
    }

    public String getScore(){

        if (playerOne.hasSameScore(playerTwo) && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";

            score += "-All";
        }

        if (playerOne.hasSameScore(playerTwo) && playerOne.isCloseToEndOfGame())
            score = "Deuce";

        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    public void P1Score(){
        playerOne.scores();
        P1point++;
    }

    public void P2Score(){
        playerTwo.scores();
        P2point++;
    }

    public void wonPoint(String player) {
        if (playerOne.isNamed(player))
            P1Score();
        else
            P2Score();
    }
}