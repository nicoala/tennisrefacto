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

    static String gameEnding(int difference) {
        return (difference == 1) ? "Advantage " : "Win for ";
    }
}
