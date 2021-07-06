package abstractExerc;

public enum CardSuit {

    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int n;

    CardSuit(int n) {
        this.n = n;
    }


    public int getN() {
        return n;
    }
}
