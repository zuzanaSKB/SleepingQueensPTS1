import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Game {

    private DrawingAndTrashPile drawingAndTrashPile;
    private Map<Integer, Player> players;
    private SleepingQueens sleepingQ;
    private GameState state;
    private GameFinishedStrategy gameFinishedStrategy;

    public Game(int numberOfPlayers) {
        drawingAndTrashPile = new DrawingAndTrashPile();
        players = new HashMap<>();
        for (int player = 0; player < numberOfPlayers; player++) {
            players.put(player, new Player(this, player));
        }
        sleepingQ = new SleepingQueens();
        state = new GameState();
        gameFinishedStrategy = new GameFinished(this);
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards) {
        return null;
    }

    public DrawingAndTrashPile getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }

    public void setDrawingAndTrashPile(DrawingAndTrashPile drawingAndTrashPile) {
        this.drawingAndTrashPile = drawingAndTrashPile;
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<Integer, Player> players) {
        this.players = players;
    }

    public SleepingQueens getSleepingQ() {
        return sleepingQ;
    }

    public void setSleepingQ(SleepingQueens sleepingQ) {
        this.sleepingQ = sleepingQ;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameFinishedStrategy getGameFinishedStrategy() {
        return gameFinishedStrategy;
    }

    public void setGameFinishedStrategy(GameFinishedStrategy gameFinishedStrategy) {
        this.gameFinishedStrategy = gameFinishedStrategy;
    }

}