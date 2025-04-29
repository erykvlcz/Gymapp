package pl.kurs.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member {
    private String name;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private Pass passType;
    private int availableEnters;
    private List<LocalDate> entersList;

    public Member(String name, LocalDate purchaseDate, LocalDate expirationDate, Pass passType, int availableEnters, List<LocalDate> entersList) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.passType = passType;
        this.availableEnters = availableEnters;
        this.entersList = entersList;
    }

    public static Member create(String name, Pass passType){
        LocalDate purchaseDate = LocalDate.now();
        LocalDate expirationDate = purchaseDate.plusDays(30);
        int availableEnters = passType.getEntersNumber();
        return new Member(name, purchaseDate, expirationDate, passType, availableEnters, new ArrayList<LocalDate>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Pass getPassType() {
        return passType;
    }

    public void setPassType(Pass passType) {
        this.passType = passType;
    }

    public int getAvailableEnters() {
        return availableEnters;
    }

    public void setAvailableEnters(int availableEnters) {
        this.availableEnters = availableEnters;
    }

    public List<LocalDate> getEntersList() {
        return entersList;
    }

    public void addEnterToList(LocalDate now){
        entersList.add(now);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", passType=" + passType +
                ", availableEnters=" + availableEnters +
                ", datesList=" + entersList +
                '}';
    }
}
