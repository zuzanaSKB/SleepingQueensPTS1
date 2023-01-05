import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GameObservable {

    // observer pattern implementation
    // convertation between internal and external types
    // hides what should not be seen

    private List<GameObserverInterface> observers;
    private Map<Integer, GameObserverInterface> playersObservers;

    public GameObservable() {
        observers = new ArrayList<>();
        playersObservers = new TreeMap<>();

    }

    public void add(GameObserverInterface observer) {
        observers.add(observer);
    }

    public void addPlayer(int playerIdx, GameObserverInterface observer) {
        if (playersObservers.size() == 5) {
            System.out.println("There are already enough players in game.");
            return;
        } else if (playerIdx > 0 && playerIdx < 5) {
            observers.add(observer);
            playersObservers.put(playerIdx, observer);
        } else {
            System.out.println("Index of player has to be between 0 and 4.");
        }
    }

    public void remove(GameObserverInterface observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void notifyAll(GameState message) {
        String m = "Game state:\n";
        m += "number of players: " + message.numberOfPlayers + "\n";
        m += "on turn: " + message.onTurn + "\n";
        m += "cardsDiscartedLastTurn: " + message.cardsDiscardedLastTurn.toString() + "\n";
        m += "sleepingQueens: " + message.sleepingQueens.toString() + "\n";
        m += "awokenQueens: " + message.awokenQueens.toString() + "\n";

        for (GameObserverInterface observer : observers) {
            observer.notify(m);
        }
    }

    public List<GameObserverInterface> getObservers() {
        return observers;
    }

    public Map<Integer, GameObserverInterface> getPlayersObservers() {
        return playersObservers;
    }

}