import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    // picks correct selected cards from hand
    // throws them into discard pile
    // redraws

    private int playerIdx;
    private List<Card> actualCardsOnHand;

    public Optional<List<Card>> pickCards(List<HandPosition> positions) {
        return null;
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw() {
        return null;
    }

    public void returnPickedCards() {

    }

    public HandPosition hasCardOfType(CardType type) {
        return null;
    }

    public List<Card> getCards() {
        return actualCardsOnHand;
    }

}