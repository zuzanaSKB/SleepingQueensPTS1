import java.util.List;

public class Player {

    private PlayerState playerState;
    private int playerIndex;
    private Game game;

    public Player(Game g, int index) {
        this.game = g;
        this.playerIndex = index;
    }

    public void play(List<Position> cards) {
        for (Position card : cards) {

        }
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

}