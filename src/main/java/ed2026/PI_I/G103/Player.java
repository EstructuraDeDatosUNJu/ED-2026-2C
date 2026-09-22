package ed2026.PI_I.G103;

public class Player {
    private String name;
    private String lastName;
    private int age;
    private int competitionScore;

    public Player(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;

        if (age <= 0 || age > 122) {
            throw new IllegalArgumentException(
                    "Age must be an integer value greater than 0 and lesser or equal to 122. Provided value: " + age);
        }
        this.age = age;
        this.competitionScore = 0;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getCompetitionScore() {
        return competitionScore;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 122) {
            throw new IllegalArgumentException(
                    "Age must be an integer value greater than 0 and less than or equal to 122. Provided value: "
                            + age);
        }
        this.age = age;
    }

    public void setCompetitionScore(int competitionScore) {
        this.competitionScore = competitionScore;
    }

    //methods
    public void addScore(int value) {
        System.out.println("***" + name.toUpperCase() + ", SCORED " + value + " POINTS***");
        competitionScore += value;
    }

    @Override
    public String toString() {
        return "----------\nPLAYER STATUS\nName: " + name + " " + lastName + "\nAge: " + age + "\nScore: "
                + competitionScore + "\n----------";
    }
}
