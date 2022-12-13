import java.util.List;

public class EvaluateNumberedCards {

    public boolean play(List<Card> cards) {
        // 1. Discard a single card of any kind and draw one card
        if (cards.size() == 1) {
            return true;
        }
        // 2. Discard pair of identical number cards and draw two cards
        if (cards.size() == 2) {
            if (cards.get(0).getValue() == cards.get(1).getValue()) {
                return true;
            } else {
                return false;
            }
        }
        // 3. Discard three or more number cards that make an addition equation and draw
        // three or more cards
        int sum = 0;
        int max = 0;
        for (Card card : cards) {
            sum += card.getValue();
            if (card.getValue() > max)
                max = card.getValue();
        }
        if ((sum - max) == max) {
            return true;
        }
        return false;
    }

}