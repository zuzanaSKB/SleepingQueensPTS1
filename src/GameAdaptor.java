import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class GameAdaptor implements GamePlayerInterface {
    // converts between internal and external types
    // calls correct object to perform each task

    private Game game;
    private GameObservable gameObservable;
    private Map<String, Integer> players; // name of player and his index in game

    public GameAdaptor(GameObservable gO, Map<String, Integer> players) {
        gameObservable = gO;
        this.players = players;
        game = new Game(players.size());
    }

    @Override
    public String play(String player, String cards) {
        if (players.size() < 2) {
            return "There is not enough players.";
        }
        if (!players.containsKey(player)) {
            return "There is no such player: " + player + " in this game.";
        }
        int indexOfPlayer = players.get(player);
        List<Position> c = new ArrayList<>();
        Scanner scanner = new Scanner(cards);
        while (scanner.hasNext()) {
            String string = scanner.next();
            char first = string.charAt(0);

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 1; i < string.length(); i++) {
                arrayList.add(Integer.parseInt(String.valueOf(string.charAt(i))));
            }

            if (first == 'h') {
                c.add(new HandPosition(arrayList.get(0), indexOfPlayer));
            } else if (first == 'a') {
                c.add(new AwokenQueenPosition(arrayList.get(1), arrayList.get(0)));
            } else if (first == 's') {
                c.add(new SleepingQueenPosition(Integer.parseInt(string.substring(1))));
            } else {
                System.out.println("Not correct input.");
            }
        }
        scanner.close();
        Optional<GameState> gameS = game.play(indexOfPlayer, c);
        if (gameS.isEmpty()) {
            return "Error!";
        }
        gameObservable.notifyAll(gameS.get());
        return "Cards were played succesfully.";

    }
}