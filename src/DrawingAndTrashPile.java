import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DrawingAndTrashPile {

    // manages drawing pile and trash pile

    private List<Card> drawingPile;
    private List<Card> trashPile;
    private List<Card> cardsDiscardedThisTurn;

    public DrawingAndTrashPile() {
        drawingPile = new ArrayList<>();
        for (int king = 0; king < 8; king++) {
            drawingPile.add(new Card(CardType.KING, king));
        }
        for (int knight = 0; knight < 4; knight++) {
            drawingPile.add(new Card(CardType.KNIGHT, knight));
        }
        for (int sleepingP = 0; sleepingP < 4; sleepingP++) {
            drawingPile.add(new Card(CardType.SLEEPING_POTION, sleepingP));
        }
        for (int wand = 0; wand < 3; wand++) {
            drawingPile.add(new Card(CardType.MAGIC_WAND, wand));
        }
        for (int dragon = 0; dragon < 3; dragon++) {
            drawingPile.add(new Card(CardType.DRAGON, dragon));
        }
        for (int i = 1; i <= 4; i++) {
            for (int num = 1; num <= 10; num++) {
                drawingPile.add(new Card(CardType.NUMBER, num));
            }
        }
        Collections.shuffle(drawingPile, new Random());
        trashPile = new ArrayList<>();
        cardsDiscardedThisTurn = new ArrayList<>();
    }

    public List<Card> discardAndDraw(List<Card> discard) {
        cardsDiscardedThisTurn = new ArrayList<>(discard);

        return null;
    }

    public void newTurn() {

    }

    public List<Card> getCardsDiscardedThisTurn() {
        return cardsDiscardedThisTurn;
    }

}