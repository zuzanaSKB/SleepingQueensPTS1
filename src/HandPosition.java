public class HandPosition extends Position {

    private int cardIndex;
    private int playerIndex;

    public HandPosition(int cIdx, int pIdx) {
        cardIndex = cIdx;
        playerIndex = pIdx;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public void setCardIndex(int index) {
        cardIndex = index;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

}