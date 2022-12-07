import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleCardsFirstMethod implements ShuffleCards {

    // when there are not enough cards,
    // the player throws his cards,
    // draws what he can and then shuffles the discard pile
    // and draw remaining cards

    private List<Card> newTrashPile;
    private List<Card> newDrawPile;

    @Override
    public List<Card> shuffle(List<Card> drawCards, List<Card> trashCards, List<Card> toDiscardCards) {
        List<Card> drawingCardsToReturn = new ArrayList<>();
        newDrawPile = new ArrayList<>(trashCards);
        newDrawPile.addAll(toDiscardCards);
        Collections.shuffle(newDrawPile, new Random());
        int restOfDraw = toDiscardCards.size() - drawCards.size();
        for (int i = 0; i < drawCards.size(); i++) {
            drawingCardsToReturn.add(drawCards.get(i));
        }
        for (int i = 0; i < restOfDraw; i++) {
            drawingCardsToReturn.add(newDrawPile.get(newDrawPile.size() - 1));
            newDrawPile.remove(newDrawPile.size() - 1);
        }

        newTrashPile = new ArrayList<>();

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