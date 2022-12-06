import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameFinished implements GameFinishedStrategy {

    private Game game;
    private int scorePoints;
    private int scoreQueens;

    public GameFinished(Game g) {
        this.game = g;

        if (game.getPlayers().size() <= 3) {
            scorePoints = 50;
            scoreQueens = 5;
        } else if (game.getPlayers().size() <= 5) {
            scorePoints = 40;
            scoreQueens = 4;
        }
    }

    @Override
    public Optional<Integer> isFinished() {
        Map<Integer, Integer> score = new HashMap<>(); //// num of score of q for each player
        Map<Integer, Integer> queens = new HashMap<>(); // num of awQ for each player
        for (Map.Entry<AwokenQueenPosition, Queen> queen : game.getState().awokenQueens.entrySet()) {
            int indexOfPlayer = queen.getKey().getPlayerIndex();
            score.put(indexOfPlayer, queen.getValue().getPoints() + score.getOrDefault(indexOfPlayer, 0));
            queens.put(indexOfPlayer, queens.getOrDefault(indexOfPlayer, 0) + 1);
        }

        int maxValue = -1;
        int indexOfmax = -1;

        for (Map.Entry<Integer, Integer> points : score.entrySet()) {
            if (points.getValue() > maxValue) {
                maxValue = points.getValue();
                indexOfmax = points.getKey();
            }
            if (points.getValue() >= scorePoints) {
                return Optional.of(points.getKey());
            }
        }

        for (Map.Entry<Integer, Integer> queen : queens.entrySet()) {
            if (queen.getValue() >= scoreQueens) {
                return Optional.of(queen.getKey());
            }
        }

        // Have the most points when all the queens have been awakened
        if (game.getSleepingQ().getQueens().isEmpty()) {
            return Optional.of(indexOfmax);
        }

        return Optional.empty();
    }

}