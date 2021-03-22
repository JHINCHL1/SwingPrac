package tournament;

public class Player {

    private String firstName;
    private String lastName;
    private int skill;
    private int id;

    public Player(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return (firstName + " " + lastName);
    }

    public int getSkill() {
        return skill;
    }

    public int getId() {
        return id;
    }

}
