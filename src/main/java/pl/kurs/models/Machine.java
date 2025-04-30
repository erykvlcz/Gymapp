package pl.kurs.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Machine {
    private String name;
    private Map<Member, Map<LocalTime, LocalTime>> machineReservationList = new HashMap<>();

    public Machine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void reserve(Member member, LocalTime newStart, LocalTime newEnd){
        if (!newStart.isBefore(newEnd)) {
            throw new IllegalArgumentException("Godzina rozpoczęcia musi być wcześniejsza niż godzina zakończenia.");
        }
        for (Map.Entry<Member, Map<LocalTime, LocalTime>> entry : machineReservationList.entrySet()) {

            Map<LocalTime, LocalTime> reservations = entry.getValue();
            for (Map.Entry<LocalTime, LocalTime> timeEntry : reservations.entrySet()) {
                LocalTime existingStart = timeEntry.getKey();
                LocalTime existingEnd = timeEntry.getValue();

                boolean overlap = newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart);

                if (overlap) {
                    throw new IllegalArgumentException("Maszyna już zarezerwowana w tym czasie!");
                }
            }
        }

        machineReservationList
                .computeIfAbsent(member, k -> new HashMap<>())
                .put(newStart, newEnd);

        System.out.println("Rezerwacja dodana");
    }

    public void cancelReservation(Member member, LocalTime start, LocalTime end) {
        Map<LocalTime, LocalTime> reservations = machineReservationList.get(member);

        if (reservations == null) {
            throw new IllegalArgumentException("Ten użytkownik nie ma żadnych rezerwacji.");
        }

        LocalTime toRemove = null;

        for (Map.Entry<LocalTime, LocalTime> entry : reservations.entrySet()) {
            LocalTime existingStart = entry.getKey();
            LocalTime existingEnd = entry.getValue();

            if (existingStart.equals(start) && existingEnd.equals(end)) {
                toRemove = existingStart;
                break;
            }
        }

        if (toRemove != null) {
            reservations.remove(toRemove);
            System.out.println("Rezerwacja anulowana.");

            if (reservations.isEmpty()) {
                machineReservationList.remove(member);
            }

            return;
        }

        throw new IllegalArgumentException("Nie znaleziono takiej rezerwacji.");
    }


}
