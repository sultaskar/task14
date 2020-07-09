package ru.sultanov;

public enum Drinks {
    COCACOLA(1, 50, "Coca-Cola"),
    FANTA(2, 48, "Fanta"),
    SPRITE(3, 52, "Sprite"),
    MIRINDA(4, 47, "Mirinda"),
    SEVENUP(5, 51, "7UP"),
    PEPSI(6, 45, "Pepsi");

    private final int position;
    private final String name;
    private final int price;

    Drinks(int position, int price, String name) {
        this.position = position;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPosition() {
        return position;
    }
}

