public class SleepingQueenPosition extends Position {

    private int cardIndex;

    public SleepingQueenPosition(int cI) {
        this.cardIndex = cI;
    }

    @Override
    public int getCardIndex() {
        return this.cardIndex;
    }

    @Override
    public void setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
    }

}