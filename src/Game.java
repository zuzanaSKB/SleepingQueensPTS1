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
            players.put(player, new Player());
        }
        sleepingQ = new SleepingQueens();
        state = new GameState();
        gameFinishedStrategy = new GameFinished(this);
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards) {
        return null;
    }

    /**
     * @return DrawingAndTrashPile return the drawingAndTrashPile
     */
    public DrawingAndTrashPile getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }

    /**
     * @param drawingAndTrashPile the drawingAndTrashPile to set
     */
    public void setDrawingAndTrashPile(DrawingAndTrashPile drawingAndTrashPile) {
        this.drawingAndTrashPile = drawingAndTrashPile;
    }

    /**
     * @return Map<Integer, Player> return the players
     */
    public Map<Integer, Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(Map<Integer, Player> players) {
        this.players = players;
    }

    /**
     * @return SleepingQueens return the sleepingQ
     */
    public SleepingQueens getSleepingQ() {
        return sleepingQ;
    }

    /**
     * @param sleepingQ the sleepingQ to set
     */
    public void setSleepingQ(SleepingQueens sleepingQ) {
        this.sleepingQ = sleepingQ;
    }

    /**
     * @return GameState return the state
     */
    public GameState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * @return GameFinishedStrategy return the gameFinishedStrategy
     */
    public GameFinishedStrategy getGameFinishedStrategy() {
        return gameFinishedStrategy;
    }

    /**
     * @param gameFinishedStrategy the gameFinishedStrategy to set
     */
    public void setGameFinishedStrategy(GameFinishedStrategy gameFinishedStrategy) {
        this.gameFinishedStrategy = gameFinishedStrategy;
    }

}