package pl.kurs.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Member {
    private String name;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private Pass passType;
    private int availableEnters;
    private List<Date> datesList;

    private Member(String name, LocalDate purchaseDate, LocalDate expirationDate, Pass passType, int availableEnters) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.passType = passType;
        this.availableEnters = availableEnters;
    }

    public static Member create(String name, Pass passType){
        LocalDate purchaseDate = LocalDate.now();
        LocalDate expirationDate = purchaseDate.plusDays(30);
        int availableEnters = passType.getEntersNumber();
        return new Member(name, purchaseDate, expirationDate, passType, availableEnters);
    }

    public Member(String name, LocalDate purchaseDate, LocalDate expirationDate, Pass passType, int availableEnters, List<Date> datesList) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.passType = passType;
        this.availableEnters = availableEnters;
        this.datesList = datesList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", passType=" + passType +
                ", availableEnters=" + availableEnters +
                ", datesList=" + datesList +
                '}';
    }
}
