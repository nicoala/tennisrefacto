public class Player {

    private String name;
    private int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    void scores() {
        score++;
    }

    boolean isNamed(String playerName) {
        return name.equals(playerName);
    }

    boolean hasSameScore(Player otherPlayer) {
        return score == otherPlayer.score;
    }

    boolean isCloseToEndOfGame() {
        return score >= 3;
    }

    boolean isCloseToWin() {
        return score >= 4;
    }

    String gameOnTheLineVs(Player otherPlayer) {
        if(Math.abs(score - otherPlayer.score) == 1) {
            return "Advantage " + hasAdvantage(otherPlayer);
        } else {
            return "Win for " + hasAdvantage(otherPlayer);
        }
    }

    private String hasAdvantage(Player otherPlayer) {
        if (score > otherPlayer.score) {
            return name;
        } else {
            return otherPlayer.name;
        }
    }

    String tennisScore() {
        return TennisScore.values()[score].toString();
    }

}
