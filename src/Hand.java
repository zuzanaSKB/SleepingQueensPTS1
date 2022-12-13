import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    // picks correct selected cards from hand
    // throws them into discard pile
    // redraws

    private Player player;
    private int playerIdx;
    private List<Card> actualCardsOnHand;
    private List<Card> cards;

    public Hand(Player p) {
        this.player = p;
        playerIdx = player.getPlayerIndex();
        actualCardsOnHand = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public List<Card> getActualCardsOnHand() {
        return actualCardsOnHand;
    }

    public void setActualCardsOnHand(List<Card> actualCardsOnHand) {
        this.actualCardsOnHand = actualCardsOnHand;
    }

    public Optional<List<Card>> pickCards(List<HandPosition> positions) {
        return null;
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw() {
        return null;
    }

    public void returnPickedCards() {

    }

    public HandPosition hasCardOfType(CardType type) {
        for (int card = 0; card < actualCardsOnHand.size(); card++) {
            if (actualCardsOnHand.get(card).getType() == type) {
                return new HandPosition(card, playerIdx);
            }
        }
        return null;
    }

}