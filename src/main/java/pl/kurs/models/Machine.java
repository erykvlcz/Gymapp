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
    private Map<LocalTime, LocalTime> reservationHours = new HashMap<>();
}
