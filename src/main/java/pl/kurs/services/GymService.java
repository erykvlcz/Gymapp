package pl.kurs.services;

import pl.kurs.models.Member;

import java.time.LocalDate;

public class GymService {
    public void enterToGym(Member member){

        int availableEnters = member.getPassType().getEnterPerDay();
        int dayEntersCounter = 0;

        if (member.getEntersList() != null) {
            for (LocalDate localDate : member.getEntersList()) {
                if (localDate.isEqual(LocalDate.now())) {
                    dayEntersCounter++;
                }
            }

            if (dayEntersCounter >= availableEnters) {
                throw new IllegalArgumentException("Limit dziennych wejść");
            }
        }
        if(member.getAvailableEnters() < 1){
            throw new IllegalArgumentException("Wykrozystano wszytkie wejśćia");
        }
        if (member.getExpirationDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Karnet jest nieważny");
        }


        member.setAvailableEnters(member.getAvailableEnters()-1);
        member.addEnterToList(LocalDate.now());
        System.out.println("Witaj na siłowni, pozostało: " + member.getAvailableEnters() + " wejść");
    }
}
