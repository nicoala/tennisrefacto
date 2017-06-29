class Score {

    static String format(Player playerOne, Player playerTwo) {
        return playerOne.tennisScore() + "-" + playerTwo.tennisScore();
    }

    static String deuce() {
        return TennisScore.DEUCE.toString();
    }

    static String playersTiedAt(String tennisScore) {
        return tennisScore + "-All";
    }

    static String gameEnding(int difference, String name) {
        return (difference == 1) ? "Advantage " + name : "Win for " + name;
    }

    static void aPlayerScores(String playerName, Player playerOne, Player playerTwo) {
        if (playerOne.isNamed(playerName)) {
            playerOne.scores();
        } else {
            playerTwo.scores();
        }
    }
}
