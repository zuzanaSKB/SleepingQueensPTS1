import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Game {

    private DrawingAndTrashPile drawingAndTrashPile;
    private Map<Integer, Player> players;
    private SleepingQueens sleepingQ;
    private GameState gameState;
    private GameFinishedStrategy gameFinishedStrategy;

    public Game(int numberOfPlayers) {
        drawingAndTrashPile = new DrawingAndTrashPile();
        players = new HashMap<>();
        for (int player = 0; player < numberOfPlayers; player++) {
            players.put(player, new Player(this, player));
        }
        sleepingQ = new SleepingQueens();
        gameState = new GameState();
        gameState.numberOfPlayers = numberOfPlayers;
        gameState.onTurn = 0;
        UpdateStateOfGame();
        gameFinishedStrategy = new GameFinished(this);
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards) {
        if (!players.containsKey(playerIdx))
            return Optional.empty();
        if (playerIdx != gameState.onTurn)
            return Optional.empty();
        if (players.get(playerIdx).play(cards)) {
            gameState.onTurn = (gameState.onTurn + 1) % gameState.numberOfPlayers;
            UpdateStateOfGame();
            drawingAndTrashPile.newTurn();
            Optional<Integer> win = gameFinishedStrategy.isFinished();
            if (win.isPresent()) {
                gameState.onTurn = -1;
                System.out.println("Congratulation, the winner is : " + win.get() + "!");
                System.out.println("Game over!");
            }
            return Optional.ofNullable(gameState);
        }
        System.out.println("New Turn.");
        return Optional.empty();
    }

    public void UpdateStateOfGame() {
        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        for (Map.Entry<Position, Queen> entry : sleepingQ.getQueens().entrySet()) {
            sleepingQueenPositions.add((SleepingQueenPosition) entry.getKey());
        }
        gameState.sleepingQueens = sleepingQueenPositions;

        gameState.cardsDiscardedLastTurn = drawingAndTrashPile.getCardsDiscardedThisTurn();

        Map<HandPosition, Optional<Card>> playersCards = new HashMap<>();
        for (Map.Entry<Integer, Player> entryPlayer : players.entrySet()) {
            for (Map.Entry<Integer, Optional<Card>> entryCards : entryPlayer.getValue().getPlayerState().getCards()
                    .entrySet()) {
                playersCards.put(new HandPosition(entryCards.getKey(), entryPlayer.getKey()), entryCards.getValue());
            }
        }
        gameState.cards = playersCards;

        Map<AwokenQueenPosition, Queen> playersQueens = new HashMap<>();
        for (Map.Entry<Integer, Player> entryPlayer : players.entrySet()) {
            for (Map.Entry<Integer, Queen> entryAwokenQueens : entryPlayer.getValue().getPlayerState().getAwokenQueens()
                    .entrySet()) {
                playersQueens.put(new AwokenQueenPosition(entryAwokenQueens.getKey(), entryPlayer.getKey()),
                        entryAwokenQueens.getValue());
            }
        }
        gameState.awokenQueens = playersQueens;

    }

    public DrawingAndTrashPile getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public SleepingQueens getSleepingQ() {
        return sleepingQ;
    }

    public GameState getGameState() {
        return gameState;
    }

}