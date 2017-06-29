public class Player {

    private String name;
    private int pointsScored;

    Player(String name, int pointsScored) {
        this.name = name;
        this.pointsScored = pointsScored;
    }

    void scores() {
        pointsScored++;
    }

    boolean isNamed(String playerName) {
        return name.equals(playerName);
    }

    boolean hasSameScore(Player otherPlayer) {
        return pointsScored == otherPlayer.pointsScored;
    }

    boolean isCloseToEndOfGame() {
        return pointsScored >= 3;
    }

    boolean isAboutToWin() {
        return pointsScored >= 4;
    }

    String gameOnTheLineVs(Player otherPlayer) {
        return Score.gameEnding(pointsDifference(otherPlayer), hasAdvantage(otherPlayer));
    }

    private int pointsDifference(Player otherPlayer) {
        return Math.abs(pointsScored - otherPlayer.pointsScored);
    }

    private String hasAdvantage(Player otherPlayer) {
        return (pointsScored > otherPlayer.pointsScored) ? name : otherPlayer.name;
    }

    String tennisScore() {
        return TennisScore.values()[pointsScored].toString();
    }

}
