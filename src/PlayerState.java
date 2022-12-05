import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    private Map<Integer, Queen> awokenQueens;

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }

    public void setCards(Map<Integer, Optional<Card>> cards) {
        this.cards = cards;
    }

    public Map<Integer, Queen> getAwokenQueens() {
        return awokenQueens;
    }

    public void setAwokenQueens(Map<Integer, Queen> awokenQueens) {
        this.awokenQueens = awokenQueens;
    }

}