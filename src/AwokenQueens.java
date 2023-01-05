import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AwokenQueens extends QueenCollection {

    private Map<Position, Queen> queens;
    private Player player;

    public AwokenQueens(Player p) {
        this.player = p;
        queens = new HashMap<>();
    }

    @Override
    void addQueen(Queen queen) {
        queens.put(new AwokenQueenPosition(queens.size(), player.getPlayerIndex()), queen);
    }

    @Override
    Optional<Queen> removeQueen(Position position) {
        int indexToRemove = position.getCardIndex();
        Optional<Queen> removedQ = Optional.ofNullable(queens.remove(position));
        for (Map.Entry<Position, Queen> queen : queens.entrySet()) {
            if (queen.getKey().getCardIndex() > indexToRemove) {
                queen.getKey().setCardIndex(queen.getKey().getCardIndex() - 1);
            }
        }
        return removedQ;
    }

    @Override
    Map<Position, Queen> getQueens() {
        return this.queens;
    }

}