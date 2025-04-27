package pl.kurs.models;

public enum Pass {
    BASIC("podstawowy", 70, 9, 1),
    STANDARD("standardowy", 105, 14, 1),
    EXTENDED("rozszerzony",140, 20, 2),
    PREMIUM("premium", 180, 1000, 1000);

    private final String name;
    private final double price;
    private final int entersNumber;
    private final int enterPerDay;

    Pass(String name, double price, int entersNumber, int enterPerDay) {
        this.name = name;
        this.price = price;
        this.entersNumber = entersNumber;
        this.enterPerDay = enterPerDay;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getEntersNumber() {
        return entersNumber;
    }

    public int getEnterPerDay() {
        return enterPerDay;
    }

    @Override
    public String toString() {
        return "Pass{" +
                "name=" + name +
                ", price=" + price +
                ", entersNumber=" + entersNumber +
                ", enterPerDay=" + enterPerDay +
                '}';
    }

}
