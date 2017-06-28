public class Player {

    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void scores() {
        score++;
    }

    public boolean isNamed(String playerName) {
        return name.equals(playerName);
    }

    public boolean hasSameScore(Player otherPlayer) {
        return score == otherPlayer.score;
    }

    public boolean isCloseToEndOfGame() {
        return score >= 3;
    }

    public boolean isCloseToWin() {
        return score >= 4;
    }

    public String gameOnTheLineVs(Player otherPlayer) {
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

    public String tennisScore() {

        return TennisScore.values()[score].toString();
    }

}
