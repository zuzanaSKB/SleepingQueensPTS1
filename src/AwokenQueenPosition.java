public class AwokenQueenPosition extends Position {

    private int cardIndex;
    private int playerIndex;

    public AwokenQueenPosition(int cI, int pI) {
        this.cardIndex = cI;
        this.playerIndex = pI;
    }

    @Override
    public int getCardIndex() {
        return this.cardIndex;
    }

    @Override
    void setCardIndex(int index) {
        this.cardIndex = index;

    }

    public int getPlayerIndex() {
        return this.playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

}