import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleCardsSecondMethod implements ShuffleCards {

    // if there are not enough cards in the deck,
    // shuffle the discard pile,
    // then discard used cards and draw cards.

    private List<Card> newTrashPile;
    private List<Card> newDrawPile;

    @Override
    public List<Card> shuffle(List<Card> drawCards, List<Card> trashCards, List<Card> toDiscardCards) {
        List<Card> drawingCardsToReturn = new ArrayList<>();
        newDrawPile = new ArrayList<>(trashCards);
        Collections.shuffle(newDrawPile, new Random());
        newDrawPile.addAll(drawCards);
        for (int i = 0; i < toDiscardCards.size(); i++) {
            drawingCardsToReturn.add(newDrawPile.get(newDrawPile.size() - 1));
            newDrawPile.remove(newDrawPile.size() - 1);
        }
        newTrashPile.addAll(toDiscardCards);
        return drawingCardsToReturn;
    }

    @Override
    public List<Card> getTrashCards() {
        return newTrashPile;
    }

    @Override
    public List<Card> getDrawCards() {
        return newDrawPile;
    }

}