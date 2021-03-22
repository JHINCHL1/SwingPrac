package tournament;


import java.io.IOException;
import java.util.Random;

/**
 * Tournament
 *
 *
 */
public class Tournament {

    private Player[] players;
    private int totalPlayers;

    /**
     * Constructor for Tournament
     *
     * takes number of players and generates them to start
     * @param totalPlayers
     */
    public Tournament(int totalPlayers) throws IOException{
        this.totalPlayers = totalPlayers;
        this.players = new Player[this.totalPlayers];
        generatePlayers();
        for (String fullName: getPlayersFullNames()) {
            System.out.println(fullName);
        }
    }

    public void generatePlayers() throws IOException {


        for (int i = 0; i < this.totalPlayers; i++) {
            // get first and last names
            String[] name = generateName();
            //String[] name = {"Bert", "Simons"};
            this.players[i] = new Player(i, name[0], name[1]);

        }
    }

    public String[] generateName() throws IOException {
        // gets array of first and last names from json files
        ReadJson[] firstNames = Readfiles.getJsonPlayers("data/firstNames.json");
        ReadJson[] lastNames = Readfiles.getJsonPlayers("data/lastNames.json");

        Random firstNameInt = new Random();
        Random lastNameInt = new Random();

        String firstName = firstNames[firstNameInt.nextInt(firstNames.length)].getFirstName();
        String lastName = lastNames[lastNameInt.nextInt(lastNames.length)].getLastName();
        String[] name = {firstName, lastName};
        System.out.println(firstName + " " + lastName);

        if (this.players[0] != null) {
            for(Player thisPlayer : this.players) {
                if(thisPlayer != null){
                    if (thisPlayer.getFirstName() == firstName) {
                        if (thisPlayer.getLastName() == lastName) {
                            name = generateName();
                        }
                    }
                }

            }

        }
        return name;
    }

    public String getPlayers() {
        return players.toString();
    }

    public String[] getPlayersFullNames() {
        String[] fullnames =new String[this.totalPlayers];
        for (int i=0; i < this.players.length; i++) {
            fullnames[i] = this.players[i].getFullName();
        }
        return fullnames;
    }
}
