package Java.lab3;

import java.sql.Date;

public class football {
    String surname;
    String pos;
    Date birthDate;
    int gamesPlayed;
    int goalsMade;

    football() {
        this.surname = "";
        this.pos = "";
        this.birthDate = null;
        this.gamesPlayed = 0;
        this.goalsMade = 0;
    }

    football(String surname, String pos, Date birthDate, int gamesPlayed, int goalsMade) {
        this.surname = surname;
        this.pos = pos;
        this.birthDate = birthDate;
        this.gamesPlayed = gamesPlayed;
        this.goalsMade = goalsMade;
    }
}
