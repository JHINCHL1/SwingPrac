package tournament;

public class Tournament {

    private Player[] players;
    private int totalPlayers;

    public Tournament(int totalPlayers) {
        this.totalPlayers = totalPlayers;
        this.players = new Player[this.totalPlayers];
        generatePlayers();
    }

    public void generatePlayers() {
        for (int i = 0; i < this.totalPlayers; i++) {
            this.players[i] = new Player(i);
        }
    }

    public String getPlayers() {
        return players.toString();
    }
}
