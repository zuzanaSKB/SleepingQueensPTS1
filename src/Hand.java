import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    // picks correct selected cards from hand
    // throws them into discard pile
    // redraws

    private Player player;
    private int playerIdx;
    private List<Card> pickedCards;
    private List<Card> cards;

    public Hand(Player p) {
        this.player = p;
        playerIdx = player.getPlayerIndex();
        pickedCards = new ArrayList<>();
        cards = new ArrayList<>();
        cards.addAll(player.getGame().getDrawingAndTrashPile().drawFullHandCards());
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Optional<List<Card>> pickCards(List<HandPosition> positions) {
        if (positions.isEmpty()) {
            return Optional.empty();
        }
        for (HandPosition handPosition : positions) {
            pickedCards.add(cards.get(handPosition.getCardIndex()));
        }
        return Optional.of(pickedCards);
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw() {
        cards.removeAll(pickedCards);
        List<Card> drawnCards = player.getGame().getDrawingAndTrashPile().discardAndDraw(pickedCards);
        Map<HandPosition, Card> handCards = new HashMap<>();
        for (int i = 0; i < drawnCards.size(); i++) {
            handCards.put(new HandPosition(cards.size() + i, playerIdx), drawnCards.get(i));
        }
        cards.addAll(drawnCards);
        returnPickedCards();
        return handCards;
    }

    public void returnPickedCards() {
        pickedCards.clear();
    }

    public HandPosition hasCardOfType(CardType type) {
        for (int card = 0; card < cards.size(); card++) {
            if (cards.get(card).getType() == type) {
                return new HandPosition(card, playerIdx);
            }
        }
        return null;
    }

}