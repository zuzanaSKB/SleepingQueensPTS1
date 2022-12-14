import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GameState {

    int numberOfPlayers;
    int onTurn;
    Set<SleepingQueenPosition> sleepingQueens;
    Map<HandPosition, Optional<Card>> cards;
    Map<AwokenQueenPosition, Queen> awokenQueens;
    List<Card> cardsDiscardedLastTurn;

}