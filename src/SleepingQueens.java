import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class SleepingQueens extends QueenCollection {

    private Map<Position, Queen> queens;

    public SleepingQueens() {
        queens = new HashMap<>();
        ArrayList<Integer> points = new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 10, 10, 10, 10, 15, 15, 15, 20));
        Collections.shuffle(points, new Random());
        for (int i = 0; i < points.size(); i++) {
            addQueen(new Queen(points.get(i)));
        }
    }

    @Override
    void addQueen(Queen queen) {
        queens.put(new SleepingQueenPosition(queens.size()), queen);

    }

    @Override
    Optional<Queen> removeQueen(SleepingQueenPosition position) {
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