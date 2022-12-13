import java.util.List;

public class Player {

    private PlayerState playerState;
    private int playerIndex;
    private Game game;
    private Hand hand;
    private AwokenQueens awokenQueens;

    public Player(Game g, int index) {
        this.game = g;
        this.playerIndex = index;
    }

    public void play(List<Position> cards) {

    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Game getGame() {
        return game;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public AwokenQueens getAwokenQueens() {
        return awokenQueens;
    }

    public void setAwokenQueens(AwokenQueens awokenQueens) {
        this.awokenQueens = awokenQueens;
    }

}