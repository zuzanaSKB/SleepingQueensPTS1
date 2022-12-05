public class Card {
    private CardType type;
    private int value;

    public Card(CardType cT, int v) {
        this.type = cT;
        this.value = v;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}