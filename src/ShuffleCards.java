import java.util.List;

public interface ShuffleCards {

    public List<Card> shuffle(List<Card> drawCards, List<Card> trashCards, List<Card> toDiscardCards);

    public List<Card> getTrashCards();

    public List<Card> getDrawCards();

}