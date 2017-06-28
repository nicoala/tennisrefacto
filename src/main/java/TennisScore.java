public enum TennisScore {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"),
    DEUCE("Deuce");

    private String score ;

    TennisScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return score;
    }
}
