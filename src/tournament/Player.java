package tournament;

public class Player {

    private String firstName;
    private String lastName;
    private int skill;
    private int id;

    public Player(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSkill() {
        return skill;
    }

    public int getId() {
        return id;
    }

}
