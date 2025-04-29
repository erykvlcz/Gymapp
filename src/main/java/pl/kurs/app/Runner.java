package pl.kurs.app;

import pl.kurs.models.Member;
import pl.kurs.models.Pass;
import pl.kurs.services.GymService;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        Member franek = Member.create("Franek", Pass.EXTENDED);
        GymService gym = new GymService();
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        gym.enterToGym(franek);
        gym.enterToGym(franek);


    }

}
