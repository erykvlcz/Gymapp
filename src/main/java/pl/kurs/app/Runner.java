package pl.kurs.app;

import pl.kurs.models.Machine;
import pl.kurs.models.Member;
import pl.kurs.models.Pass;
import pl.kurs.services.GymService;

import java.time.LocalDate;
import java.time.LocalTime;

public class Runner {
    public static void main(String[] args) {
        Member franek = Member.create("Franek", Pass.EXTENDED);
        Member witek = Member.create("Witek", Pass.BASIC);
        GymService gym = new GymService();
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        Machine wyciag = new Machine("Wciąg");
        wyciag.reserve(franek, LocalTime.of(12, 0), LocalTime.of(13, 1));
        wyciag.reserve(witek, LocalTime.of(10, 0), LocalTime.of(11, 0));
        wyciag.cancelReservation(franek, LocalTime.of(12, 0), LocalTime.of(13, 1));

    }

}
